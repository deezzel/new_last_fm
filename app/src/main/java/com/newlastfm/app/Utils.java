package com.newlastfm.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by deezzel on 6/26/14.
 */
public class Utils {
    public static Bitmap getAvatarFromLink(URL url) {
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (Exception e){
            throw new RuntimeException();
        }
        return bmp;
    }

    public static String buildApiSig(String apiKey, String apiMethod, String password, String username, String apiSecret) {
        String checksum = "";
        try {
            String api_sig = "api_key" + apiKey + "method" + apiMethod + "password" + password + "username" + username + apiSecret;
            byte[] bytes = api_sig.getBytes("UTF-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(bytes);

            StringBuilder stringBuilder = new StringBuilder(32);
            for (byte aByte : digest) {
                String hex = Integer.toHexString((int) aByte & 0xFF);
                if (hex.length() == 1)
                    stringBuilder.append('0');
                stringBuilder.append(hex);

            }
            checksum = stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return checksum;
    }
}
