package com.newlastfm.app.rest;

import com.newlastfm.model.RequestError;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/21/14.
 */
public class RequestResult<T> {
    private final T data;
    private final RequestError requestError;
    private RequestResultStatus status;

    public RequestResult(T data) {
        this.data = data;
        this.requestError = null;
        status = RequestResultStatus.HAS_RESULT;
    }

    public RequestResult(RequestError requestError) {
        this.data = null;
        this.requestError = requestError;
        status = RequestResultStatus.HAS_ERROR;
    }

    public T getData() {
        return data;
    }

    public RequestError getRequestError() {
        return requestError;
    }

    public RequestResultStatus getStatus() {
        return status;
    }
}
