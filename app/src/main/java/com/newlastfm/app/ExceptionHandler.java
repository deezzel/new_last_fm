package com.newlastfm.app;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/18/14.
 */
public class ExceptionHandler {
    public static int MODE = 0;

    public static void handle(Exception ex) {
        if (MODE == Constants.DEVELOPMENT)
            throw new RuntimeException(ex);
        else {
            // TODO: send logs to the server
        }
    }
}
