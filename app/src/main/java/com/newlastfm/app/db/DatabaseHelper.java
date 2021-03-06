package com.newlastfm.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.newlastfm.app.Constants;
import com.newlastfm.app.ExceptionHandler;
import com.newlastfm.model.Artist;
import com.newlastfm.model.User;
import com.newlastfm.model.dao.ArtistDAO;
import com.newlastfm.model.dao.UserDAO;

import java.sql.SQLException;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 6/12/14.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "newlastfm.db";
    private static final int DATABASE_VERSION = 3;

    public final UserDAO userDAO;
    public final ArtistDAO artistDAO;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        try {
            userDAO = new UserDAO(getConnectionSource(), User.class);
            artistDAO = new ArtistDAO(getConnectionSource(), Artist.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Artist.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        try {
            TableUtils.dropTable(connectionSource, User.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (final SQLException e) {
            ExceptionHandler.handle(e);
            Log.e(Constants.TAG, "Error upgrading db " + DATABASE_NAME + "from version " + i);
        }
    }
}
