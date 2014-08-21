package com.newlastfm.app.db;

import com.newlastfm.model.dao.UserDAO;

import org.androidannotations.annotations.EBean;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/18/14.
 */
@EBean(scope = EBean.Scope.Singleton)
public class Storage {
    private UserDAO userDAO;

    public void init(DatabaseHelper databaseHelper) {
        userDAO = databaseHelper.userDAO;
    }
}
