package com.newlastfm.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

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
        } catch (Exception e) {
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

    public static String buildApiSig(String apiKey, String apiMethod, String sessionKey, String apiSecret,
                                     String page, String limit) {
        String checksum = "";
        try {
            String api_sig = "api_key" + apiKey + "limit" + limit + "method" + apiMethod + "page" + page + "sk" +
                    sessionKey + apiSecret;
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

    public static Bitmap getRoundedBitmap(Bitmap bmp, int radius) {
        Bitmap sbmp;
        if (bmp.getWidth() != radius || bmp.getHeight() != radius)
            sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
        else
            sbmp = bmp;
        Bitmap output = Bitmap.createBitmap(sbmp.getWidth(),
                sbmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xffa19774;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#FFFFFF"));
        canvas.drawCircle(sbmp.getWidth() / 2 + 0.7f, sbmp.getHeight() / 2 + 0.7f,
                sbmp.getWidth() / 2 + 0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);

        return output;
    }
}
