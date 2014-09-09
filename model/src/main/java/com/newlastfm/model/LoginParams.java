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

    public LoginParams(String username, String password, String method, String apiKey, String apiSig) {
        this.username = username;
        this.password = password;
        this.method = method;
        this.apiKey = apiKey;
        this.apiSig = apiSig;
    }

    public LoginParams() {
    }
}
