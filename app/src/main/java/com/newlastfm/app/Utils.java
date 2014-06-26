package com.newlastfm.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.net.URL;

/**
 * Created by deezzel on 6/26/14.
 */
public class Utils {
    public Bitmap getAvatarFromLink(URL url){
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (Exception e){
            throw new RuntimeException();
        }
        return bmp;
    }
}
