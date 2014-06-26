package com.newlastfm.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.newlastfm.model.User;
import com.newlastfm.model.dao.UserDAO;

import java.sql.SQLException;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 6/12/14.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "newlastfm.db";
    private static final int DATABASE_VERSION = 1;

    private UserDAO userDAO;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        try {
            setUserDAO(new UserDAO(getConnectionSource(), User.class));
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {

    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
