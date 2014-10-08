package com.newlastfm.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.newlastfm.model.dao.ArtistDAO;

import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 10/8/14.
 */
@DatabaseTable(daoClass = ArtistDAO.class)
public class Artist {
    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField(dataType = DataType.STRING)
    public String name;
    @DatabaseField(dataType = DataType.STRING)
    public String mbid;
    @DatabaseField(dataType = DataType.STRING)
    public String url;
    @DatabaseField(dataType = DataType.INTEGER)
    public int streamable;
    public List<Image> image;
    @DatabaseField(dataType = DataType.STRING)
    public String image_url;

    public static Artist newInstance(String name, String mbid, String url, int streamable, String image_url) {
        Artist artist = new Artist();
        artist.name = name;
        artist.mbid = mbid;
        artist.url = url;
        artist.streamable = streamable;
        artist.image_url = image_url;
        return artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStreamable() {
        return streamable;
    }

    public void setStreamable(int streamable) {
        this.streamable = streamable;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}
