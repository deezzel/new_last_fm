package com.newlastfm.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.newlastfm.model.dao.UserDAO;

@DatabaseTable(daoClass = UserDAO.class)
public class User {
    public static int ID = 1;

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(dataType = DataType.STRING, canBeNull = false)
    public String name;
    @DatabaseField(dataType = DataType.STRING, canBeNull = false)
    public String realname;
    @DatabaseField(dataType = DataType.STRING, canBeNull = false)
    public String avatar_url;
    @DatabaseField(dataType = DataType.INTEGER)
    public int playcount;
    @DatabaseField(dataType = DataType.STRING)
    public String url;
    @DatabaseField(dataType = DataType.STRING)
    public String country;
    @DatabaseField(dataType = DataType.INTEGER)
    public int age;
    @DatabaseField(dataType = DataType.STRING)
    public String gender;
    @DatabaseField(dataType = DataType.STRING)
    public String registered;
    @DatabaseField(dataType = DataType.INTEGER)
    public int playlists;

    public static User newInstance(String name, String realname, String avatar_url, int playcount, String url,
                                   String country, int age, String gender, String registered, int playlists) {
        User user = new User();
        user.id = ID;
        user.name = name;
        user.realname = realname;
        user.avatar_url = avatar_url;
        user.playcount = playcount;
        user.url = url;
        user.country = country;
        user.age = age;
        user.gender = gender;
        user.registered = registered;
        user.playlists = playlists;
        return user;
    }
}
