package com.newlastfm.gson;

import com.google.gson.Gson;
import com.newlastfm.model.SessionData;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 9/5/14.
 */
public class GSONSessionDataTest {

    String jsonString = "{\n" +
            "    \"session\": {\n" +
            "        \"name\": \"deezzel07\",\n" +
            "        \"key\": \"1475916ca07989833098ad18c914bb71\",\n" +
            "        \"subscriber\": \"0\"\n" +
            "    }\n" +
            "}";

    @Test
    public void test() {
        Gson gson = new Gson();
        SessionData sessionData = gson.fromJson(jsonString, SessionData.class);
        assertNotNull(sessionData.getSession().getKey());
        assertNotNull(sessionData.getSession().getName());
    }
}
