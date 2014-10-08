package com.newlastfm.app.db;

import com.newlastfm.app.ExceptionHandler;
import com.newlastfm.model.Artist;
import com.newlastfm.model.User;
import com.newlastfm.model.dao.ArtistDAO;
import com.newlastfm.model.dao.UserDAO;

import org.androidannotations.annotations.EBean;

import java.sql.SQLException;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/18/14.
 */
@EBean(scope = EBean.Scope.Singleton)
public class Storage {
    private UserDAO userDAO;
    private ArtistDAO artistDAO;

    public void init(DatabaseHelper databaseHelper) {
        userDAO = databaseHelper.userDAO;
        artistDAO = databaseHelper.artistDAO;
    }

    public User getUser() {
        return userDAO.get();
    }

    public User update(User user) {
        if (user == null) throw new IllegalArgumentException("Can't update null user");
        try {
            userDAO.createOrUpdate(user);
        } catch (SQLException e) {
            ExceptionHandler.handle(e);
        }
        return getUser();
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public Artist create(Artist artist) {
        artistDAO.create(artist);
        return artist;
    }

    public Artist getByMBID(String mbid) {
        return artistDAO.getByMBID(mbid);
    }

    public Artist getById(int id) {
        return artistDAO.getById(id);
    }
}
