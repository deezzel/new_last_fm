package com.newlastfm.gson;

import com.google.gson.Gson;

import org.junit.Test;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/18/14.
 */
public class GSONArrayTest {

    public String jsonString = "{\"#text\":\"2010-04-01 16:41\",\"unixtime\":\"1270140106\"}";

    @Test
    public void test() {
        Gson gson = new Gson();
        String[] strings = gson.fromJson(jsonString, String[].class);
    }
}
