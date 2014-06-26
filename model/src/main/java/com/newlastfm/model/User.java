package com.newlastfm.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.newlastfm.model.dao.UserDAO;

@DatabaseTable(daoClass = UserDAO.class)
public class User {

    private static final String NAME_FIELD = "name";

    public User(String name, String playcount, String avatar_url){
        this.setName(name);
        this.setAvatar_url(avatar_url);
        this.setPlaycount(playcount);
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(dataType = DataType.STRING, columnName = NAME_FIELD)
    private String name;

    @DatabaseField(dataType = DataType.STRING, columnName = "avatar_url")
    private String avatar_url;

    @DatabaseField(dataType = DataType.STRING)
    private String playcount;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }
}
