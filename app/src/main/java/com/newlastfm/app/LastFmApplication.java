package com.newlastfm.app;

import android.app.Application;

import com.newlastfm.app.db.DatabaseHelperFactory;
import com.newlastfm.app.db.Storage;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/28/14.
 */
@EApplication
public class LastFmApplication extends Application {
    @Bean
    DatabaseHelperFactory databaseHelperFactory;
    @Bean
    Storage storage;

    public void onCreate() {
        super.onCreate();
        storage.init(databaseHelperFactory.init(getApplicationContext()));
    }

    @Override
    public void onTerminate() {
        databaseHelperFactory.releaseHelper();
        super.onTerminate();
    }
}
