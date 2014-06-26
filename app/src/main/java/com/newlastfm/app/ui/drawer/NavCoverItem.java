package com.newlastfm.app.ui.drawer;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 6/18/14.
 */
public class NavCoverItem {
    private int drawableResID;
    private String fullName;

    public NavCoverItem(int drawableResID, String name) {
        super();
        this.setDrawableResID(drawableResID);
        this.setFullName(name);
    }

    public int getDrawableResID() {
        return drawableResID;
    }

    public void setDrawableResID(int drawableResID) {
        this.drawableResID = drawableResID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
