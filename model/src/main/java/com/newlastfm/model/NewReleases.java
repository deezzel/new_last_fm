package com.newlastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 10/3/14.
 */
public class NewReleases {
    private Albums albums;

    public static final class Albums {
        private List<Album> album;
        @SerializedName("@attr")
        private Info info;
    }

    public static final class Album {
        private String name;
        private String mbid;
        private String url;
        private Artist artist;
        private List<Image> image;
        @SerializedName("@attr")
        private Release release;
    }

    public static final class Artist {
        private String name;
        private String mbid;
        private String url;

    }

    public static final class Release {
        private String releasedate;
    }

    public static final class Info {
        private String user;
        private String source;
    }
}
