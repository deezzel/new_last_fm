package com.newlastfm.model.dao;

import com.j256.ormlite.support.ConnectionSource;
import com.newlastfm.model.Artist;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 10/8/14.
 */
public class ArtistDAO extends BaseDAO<Artist, Integer> {
    public ArtistDAO(ConnectionSource connectionSource, Class<Artist> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public Artist getByMBID(String mbid) {
        List<Artist> artists;
        try {
            artists = queryForEq("mbid", mbid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (artists != null && artists.size() > 0) ? artists.get(0) : null;
    }

    public Artist getById(int id) {
        return queryForId(id);
    }
}
