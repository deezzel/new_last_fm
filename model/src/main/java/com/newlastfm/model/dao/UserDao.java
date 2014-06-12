package com.newlastfm.model.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.newlastfm.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by deezzel on 6/12/14.
 */
public class UserDao extends BaseDao<User,Integer> {
    public UserDao(ConnectionSource connectionSource, Class dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public User getByName(String name){
        try {
            final List<User> userList = queryForEq("name",name);
            return (userList!=null && userList.size()>0) ? userList.get(0) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
