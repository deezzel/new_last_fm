package com.newlastfm.gson;

import com.google.gson.Gson;
import com.newlastfm.model.UserData;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/18/14.
 */
public class GSONUserDataTest {

    public String jsonStr = "{\n" +
            "    \"user\": {\n" +
            "        \"name\": \"deezzel07\",\n" +
            "        \"realname\": \"Тёма Михельсон\",\n" +
            "        \"image\": [\n" +
            "            {\n" +
            "                \"#text\": \"http://userserve-ak.last.fm/serve/34/86765245.jpg\",\n" +
            "                \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"#text\": \"http://userserve-ak.last.fm/serve/64/86765245.jpg\",\n" +
            "                \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"#text\": \"http://userserve-ak.last.fm/serve/126/86765245.jpg\",\n" +
            "                \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"#text\": \"http://userserve-ak.last.fm/serve/252/86765245.jpg\",\n" +
            "                \"size\": \"extralarge\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"url\": \"http://www.last.fm/user/deezzel07\",\n" +
            "        \"id\": \"28454363\",\n" +
            "        \"country\": \"UA\",\n" +
            "        \"age\": \"24\",\n" +
            "        \"gender\": \"m\",\n" +
            "        \"subscriber\": \"0\",\n" +
            "        \"playcount\": \"72737\",\n" +
            "        \"playlists\": \"2\",\n" +
            "        \"bootstrap\": \"0\",\n" +
            "        \"registered\": {\n" +
            "            \"#text\": \"2010-04-01 16:41\",\n" +
            "            \"unixtime\": \"1270140106\"\n" +
            "        },\n" +
            "        \"type\": \"user\"\n" +
            "    }\n" +
            "}";

    @Test
    public void test() {
        Gson gson = new Gson();
        UserData userData = gson.fromJson(jsonStr, UserData.class);
        assertNotNull(userData.getUser().getName());
        assertNotNull(userData.getUser().getImage());
    }
}
