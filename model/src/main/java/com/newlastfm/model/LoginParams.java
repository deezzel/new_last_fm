package com.newlastfm.model;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 9/3/14.
 */
public class LoginParams {
    private String username;
    private String password;
    private String apiKey;
    private String apiSig;
    private String method;
    private String format;

    public LoginParams(String username, String password, String apiKey,
                       String apiSig, String method, String format) {
        this.username = username;
        this.password = password;
        this.apiKey = apiKey;
        this.apiSig = apiSig;
        this.method = method;
        this.format = format;
    }

    public LoginParams() {
    }
}
