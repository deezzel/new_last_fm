package com.newlastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 10/3/14.
 */
public class Image {
    @SerializedName("#text")
    private String text;
    private String size;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
