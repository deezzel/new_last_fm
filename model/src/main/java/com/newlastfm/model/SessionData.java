package com.newlastfm.model;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 9/3/14.
 */
public class SessionData {

    private SessionInfo session;

    public SessionInfo getSession() {
        return session;
    }

    public void setSession(SessionInfo session) {
        this.session = session;
    }

    public static final class SessionInfo {
        private String name;
        private String key;
        private int subscriber;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getSubscriber() {
            return subscriber;
        }

        public void setSubscriber(int subscriber) {
            this.subscriber = subscriber;
        }
    }
}
