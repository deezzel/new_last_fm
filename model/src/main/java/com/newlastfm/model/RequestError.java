package com.newlastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/21/14.
 */
public class RequestError {
    @SerializedName("error")
    private int errorCode;
    @SerializedName("message")
    private String message;

    public RequestError(int errorCode) {
        this.errorCode = errorCode;
    }

    public RequestError(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public RequestError(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return message;
    }
}
