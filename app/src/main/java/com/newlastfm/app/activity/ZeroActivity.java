package com.newlastfm.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.newlastfm.app.AppContext;

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
        startActivity(new Intent(this, SplashActivity_.class));
        finish();
    }
}
