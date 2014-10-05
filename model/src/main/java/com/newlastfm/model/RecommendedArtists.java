package com.newlastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 9/9/14.
 */
public class RecommendedArtists {

    private RecommendationsInfo recommendations;
    @SerializedName("@attr")
    private Attributes attr;

    public RecommendationsInfo getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(RecommendationsInfo recommendations) {
        this.recommendations = recommendations;
    }

    public Attributes getAttr() {
        return attr;
    }

    public void setAttr(Attributes attr) {
        this.attr = attr;
    }

    public static final class RecommendationsInfo {
        private List<ParentArtist> artist;

        public List<ParentArtist> getArtist() {
            return artist;
        }

        public void setArtist(List<ParentArtist> artist) {
            this.artist = artist;
        }
    }

    public static final class ParentArtist {
        private String name;
        private String mbid;
        private String url;
        private int streamable;
        private List<Image> image;
        private Context context;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMbid() {
            return mbid;
        }

        public void setMbid(String mbid) {
            this.mbid = mbid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getStreamable() {
            return streamable;
        }

        public void setStreamable(int streamable) {
            this.streamable = streamable;
        }

        public List<Image> getImage() {
            return image;
        }

        public void setImage(List<Image> image) {
            this.image = image;
        }

        public Context getContext() {
            return context;
        }

        public void setContext(Context context) {
            this.context = context;
        }
    }

    public static final class Context {
        @SerializedName("artist")
        private List<Artist> artists;
        private Artist artist;

        public List<Artist> getArtists() {
            return artists;
        }

        public void setArtists(List<Artist> artists) {
            this.artists = artists;
        }

        public Artist getArtist() {
            return artist;
        }

        public void setArtist(Artist artist) {
            this.artist = artist;
        }
    }

    public static final class Artist {
        private String name;
        private String mbid;
        private String url;
        private int streamable;
        private List<Image> image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMbid() {
            return mbid;
        }

        public void setMbid(String mbid) {
            this.mbid = mbid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getStreamable() {
            return streamable;
        }

        public void setStreamable(int streamable) {
            this.streamable = streamable;
        }

        public List<Image> getImage() {
            return image;
        }

        public void setImage(List<Image> image) {
            this.image = image;
        }
    }

    public static final class Attributes {
        private String user;
        private int page;
        private int perPage;
        private int totalPages;
        private int total;

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPerPage() {
            return perPage;
        }

        public void setPerPage(int perPage) {
            this.perPage = perPage;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
}
