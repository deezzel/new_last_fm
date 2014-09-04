package com.newlastfm.app.validation;

import android.util.Patterns;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 9/3/14.
 */
public class ValidationUtils {
    public static boolean isValidEmail(final CharSequence target) {
        return target != null && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static boolean isValidPhone(final CharSequence target) {
        return target != null && Patterns.PHONE.matcher(target).matches();
    }

    public static boolean isValidUrl(final CharSequence target) {
        return target != null && Patterns.WEB_URL.matcher(target).matches();
    }

    public static boolean isNumber(final CharSequence target) {
        if (target == null) {
            return false;
        } else {
            try {
                Integer.parseInt(target.toString());
                return true;
            } catch (final NumberFormatException e) {
                return false;
            }
        }
    }
}
