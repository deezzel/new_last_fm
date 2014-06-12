package com.newlastfm.model.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 6/12/14.
 */
public class BaseDAO  <T,ID> extends BaseDaoImpl<T,ID> {


    protected BaseDAO(ConnectionSource connectionSource, Class<T> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<T> getAll() {
        try {
            return queryForAll();
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int create(T data) {
        try {
            return super.create(data);
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int update(T data) {
        try {
            return super.update(data);
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int refresh(T data) {
        try {
            return super.refresh(data);
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public T queryForId(ID id) {
        try {
            return super.queryForId(id);
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int delete(T data) {
        try {
            return super.delete(data);
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
