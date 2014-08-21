package com.newlastfm.app.db;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import org.androidannotations.annotations.EBean;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/18/14.
 */
@EBean(scope = EBean.Scope.Singleton)
public class DatabaseHelperFactory {
    private DatabaseHelper databaseHelper;

    public DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }

    public DatabaseHelper init(Context context) {
        databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        return databaseHelper;
    }

    public void releaseHelper() {
        OpenHelperManager.releaseHelper();
        databaseHelper = null;
    }
}
