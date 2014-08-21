package com.newlastfm.app.rest;

import com.newlastfm.model.UserData;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/21/14.
 */

@Rest(rootUrl = "http://ws.audioscrobbler.com/2.0/", converters = {GsonHttpMessageConverter.class, StringHttpMessageConverter.class})
public interface IRestClient {

    @Get("?method={method}&user={userName}&api_key={apiKey}&format={format}")
    @Accept(MediaType.APPLICATION_JSON)
    ResponseEntity<UserData> getUserInfo(String method, String userName, String apiKey, String format);

    RestTemplate getRestTemplate();
}
