package com.newlastfm.app;

import org.androidannotations.annotations.EBean;
import org.json.JSONObject;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by deezzel on 6/26/14.
 */

@EBean(scope = EBean.Scope.Singleton)
public class LastFmSession {
    private RestTemplate restTemplate;

    public RestTemplate initRestTempate(){
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        return restTemplate;
    }

    public JSONObject doGetRequest(String url){
        try {
            return new JSONObject(initRestTempate().getForObject(url, String.class));
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    public String doPostRequest(String url, MultiValueMap<String, String> map){
        try {
            return initRestTempate().postForObject(url, map, String.class);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    public String formURLToGetUserInfo(String apiUrl, String apiKey, String apiMethod, String format, String username){
        return apiUrl+"method="+apiMethod+"&user="+username+"&api_key="+apiKey+"&format="+format;
    }
}
