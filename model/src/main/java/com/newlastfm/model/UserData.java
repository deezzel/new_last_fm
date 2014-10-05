package com.newlastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/18/14.
 */
public class UserData {
    private UserInfo user;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public static final class UserInfo {
        private String name;
        private String realname;
        private List<Image> image;
        private String url;
        private int id;
        private String country;
        private int age;
        private String gender;
        private int subscriber;
        private int playcount;
        private int playlists;
        private int bootstrap;
        private RegisterDate registered;
        private String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public List<Image> getImage() {
            return image;
        }

        public void setImage(List<Image> image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getSubscriber() {
            return subscriber;
        }

        public void setSubscriber(int subscriber) {
            this.subscriber = subscriber;
        }

        public int getPlaycount() {
            return playcount;
        }

        public void setPlaycount(int playcount) {
            this.playcount = playcount;
        }

        public int getPlaylists() {
            return playlists;
        }

        public void setPlaylists(int playlists) {
            this.playlists = playlists;
        }

        public int getBootstrap() {
            return bootstrap;
        }

        public void setBootstrap(int bootstrap) {
            this.bootstrap = bootstrap;
        }

        public RegisterDate getRegistered() {
            return registered;
        }

        public void setRegistered(RegisterDate registered) {
            this.registered = registered;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public static final class RegisterDate {
            @SerializedName("#text")
            private String text;
            private String unixtime;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(String unixtime) {
                this.unixtime = unixtime;
            }
        }
    }
}
