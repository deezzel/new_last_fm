package com.newlastfm.app.rest;

import android.util.Log;

import com.google.gson.Gson;
import com.newlastfm.app.Constants;
import com.newlastfm.model.RecommendedArtists;
import com.newlastfm.model.RequestError;
import com.newlastfm.model.SessionData;
import com.newlastfm.model.UserData;
import com.newlastfm.model.params.RecommendedArtistsParams;

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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

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

    public SessionData manualLogin(final String params) {
        SessionData sessionData = null;
        String jsonResponse = "";
        try {
            URL url = new URL(Constants.apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            OutputStream dataOutputStream = urlConnection.getOutputStream();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dataOutputStream));
            writer.write(params);
            writer.close();

            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                jsonResponse = sb.toString();
            }
            Gson gson = new Gson();
            sessionData = gson.fromJson(jsonResponse, SessionData.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionData;
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

    public RequestResult<RecommendedArtists> getRecommendedArtists(final String api_sig, final String api_key,
                                                                   final String method, final String sk,
                                                                   final String format) {
        final RequestResult<RecommendedArtists> result = executeRequest(new Request<RecommendedArtists>() {
            @Override
            public ResponseEntity<RecommendedArtists> execute() {
                return restClient.getRecommendedArtists(new RecommendedArtistsParams(api_sig, api_key, method, sk, format));
            }
        });
        if (result.getRequestError() == null) {
            Log.i(Constants.TAG, "Success");
        }
        return result;
    }

    public RecommendedArtists getRecommendedArtists(String params) {
        RecommendedArtists recommendedArtists = null;
        String jsonResponse = "";
        try {
            URL url = new URL(Constants.apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            OutputStream dataOutputStream = urlConnection.getOutputStream();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dataOutputStream));
            writer.write(params);
            writer.close();

            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                jsonResponse = sb.toString();
            }
            Gson gson = new Gson();
            recommendedArtists = gson.fromJson(jsonResponse, RecommendedArtists.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recommendedArtists;
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
