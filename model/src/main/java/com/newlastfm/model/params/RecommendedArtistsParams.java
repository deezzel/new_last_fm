package com.newlastfm.model.params;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 9/15/14.
 */
public class RecommendedArtistsParams {
    private String api_sig;
    private String api_key;
    private String method;
    private String sk;
    private String format;

    public RecommendedArtistsParams(String api_sig, String api_key, String method, String sk, String format) {
        this.api_key = api_key;
        this.api_sig = api_sig;
        this.method = method;
        this.sk = sk;
        this.format = format;
    }
}
