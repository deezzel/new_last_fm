package com.newlastfm.model.dao;

import com.j256.ormlite.support.ConnectionSource;
import com.newlastfm.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 6/12/14.
 */
public class UserDAO extends BaseDAO<User, Integer> {

    public UserDAO(ConnectionSource connectionSource, Class<User> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public User getByName(String name) {
        try {
            final List<User> userList = queryForEq("name", name);
            return (userList != null && userList.size() > 0) ? userList.get(0) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User get() {
        return queryForId(User.ID);
    }
}