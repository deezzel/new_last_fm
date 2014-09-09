package com.newlastfm.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.newlastfm.app.AppContext;
import com.newlastfm.app.MainActivity_;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/29/14.
 */

@EActivity
public class ZeroActivity extends Activity {
    @Bean
    AppContext ctx;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        if (ctx.storage.getUser() == null) {
            startActivity(new Intent(this, SplashLoginActivity_.class));
            finish();
        } else {
            startActivity(new Intent(this, MainActivity_.class));
        }
    }
}
