package com.newlastfm.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.newlastfm.model.dao.UserDao;

@DatabaseTable(daoClass = UserDao.class)
public class User {

    private static final String NAME_FIELD = "name";

    public User(String name){
        this.setName(name);
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(dataType = DataType.STRING, columnName = NAME_FIELD)
    private String name;


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
}
