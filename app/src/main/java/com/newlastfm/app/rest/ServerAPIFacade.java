package com.newlastfm.app.rest;

import android.util.Log;

import com.google.gson.Gson;
import com.newlastfm.app.Constants;
import com.newlastfm.model.LoginParams;
import com.newlastfm.model.RequestError;
import com.newlastfm.model.SessionData;
import com.newlastfm.model.UserData;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.rest.RestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/21/14.
 */

@EBean(scope = EBean.Scope.Singleton)
public class ServerAPIFacade {
    @RestService
    public IRestClient restClient;

    private RestTemplate template;

    @AfterInject
    void init() {
        template = restClient.getRestTemplate();
        template.setErrorHandler(new CustomResponseErrorHandler());
    }

    public RequestResult<SessionData> login(final String username, final String password,
                                            final String method, final String apiKey, final String apiSig) {
        final RequestResult<SessionData> result = executeRequest(new Request<SessionData>() {
            @Override
            public ResponseEntity<SessionData> execute() {
                return restClient.login(new LoginParams(username, password, method, apiKey, apiSig));
            }
        });

        if (result.getRequestError() == null) {
            Log.i(Constants.TAG, "Success");
        }
        return result;
    }

    public RequestResult<UserData> getUserInfo(final String method, final String userName, final String apiKey, final String format) {
        final RequestResult<UserData> result = executeRequest(new Request<UserData>() {
            @Override
            public ResponseEntity<UserData> execute() {
                return restClient.getUserInfo(method, userName, apiKey, format);
            }
        });
        if (result.getRequestError() == null) {
            Log.i(Constants.TAG, "Success");
        }
        return result;
    }

    private boolean checkHttpStatus(HttpStatus status) {
        switch (status) {
            case ACCEPTED:
            case CREATED:
            case OK:
                return true;
            default:
                return false;
        }
    }

    private <T> RequestResult<T> executeRequest(Request<T> request) {
        try {
            ResponseEntity<T> responseEntity = request.execute();
            if (checkHttpStatus(responseEntity.getStatusCode())) {
                return new RequestResult<T>(responseEntity.getBody());
            } else {
                return new RequestResult<T>(new RequestError(responseEntity.getBody().toString()));
            }
        } catch (BadRequestException e) {
            Log.e(Constants.TAG, e.getLocalizedMessage(), e);
            return new RequestResult<T>(new RequestError(e.getErrorRequestMessage().toString()));
        } catch (ResourceAccessException e) {
            Log.e(Constants.TAG, e.getLocalizedMessage(), e);
            return new RequestResult<T>(new RequestError("Can't connect to server"));
        } catch (Exception e) {
            e.printStackTrace();
            return new RequestResult<T>(new RequestError("Can't connect to server"));
        }
    }

    private interface Request<T> {
        ResponseEntity<T> execute();
    }

    public class CustomResponseErrorHandler implements ResponseErrorHandler {

        private ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            try {
                errorHandler.handleError(response);
            } catch (HttpClientErrorException e) {
                Log.e(Constants.TAG, e.getResponseBodyAsString());
                RequestError requestError = new Gson().fromJson(e.getResponseBodyAsString(), RequestError.class);
                // String requestError = EntityUtils.toString(response.getBody(), HTTP.UTF_8));
                BadRequestException exception = new BadRequestException(response.getStatusCode());
                exception.setRequestMessage(requestError);
                throw exception;
            }
        }

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            return errorHandler.hasError(response);
        }
    }

    public class BadRequestException extends HttpClientErrorException {
        RequestError message;

        public BadRequestException(HttpStatus statusCode) {
            super(statusCode);
        }

        public void setRequestMessage(RequestError message) {
            this.message = message;
        }

        public RequestError getErrorRequestMessage() {
            return message;
        }
    }
}
