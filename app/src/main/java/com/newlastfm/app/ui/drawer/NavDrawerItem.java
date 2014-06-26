package com.newlastfm.app.ui.drawer;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 6/13/14.
 */
public class NavDrawerItem {
    private String title;
    private int icon;
    private String count = "0";
    // boolean to set visiblity of the counter
    private boolean isCounterVisible = false;
    private String drawerTitle;
    boolean isSpinner = false;
    boolean isCover = false;
    private String fullName;
    private int userAvatar;

    public NavDrawerItem(){}

    public NavDrawerItem(String title, int icon){
        this.title = title;
        this.icon = icon;
    }
//    public NavDrawerItem(boolean isSpinner) {
//        this(null, 0);
//        this.isSpinner = isSpinner;
//    }

    public NavDrawerItem(boolean isCover, String fullName, int userAvatar) {
        this.isCover = isCover;
        this.setFullName(fullName);
        this.setUserAvatar(userAvatar);
    }

    public NavDrawerItem(boolean isSpinner){
        this(null,0);
        this.isSpinner = isSpinner;
    }

    public NavDrawerItem(String drawerTitle) {
        this(null, 0);
        this.drawerTitle = drawerTitle;
    }

    public NavDrawerItem(String title, int icon, boolean isCounterVisible, String count){
        this.title = title;
        this.icon = icon;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
        this.isSpinner = false;
        this.drawerTitle = null;
    }
    public NavDrawerItem(String title, int icon, boolean isCounterVisible, String count, boolean isSpinner){
        this.title = title;
        this.icon = icon;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
        this.isSpinner = isSpinner;
    }

    public NavDrawerItem(String title, int icon, boolean isCounterVisible, String count, boolean isSpinner, String drawerTitle){
        this.title = title;
        this.icon = icon;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
        this.isSpinner = isSpinner;
        this.drawerTitle = drawerTitle;
    }

    public String getTitle(){
        return this.title;
    }

    public int getIcon(){
        return this.icon;
    }

    public String getCount(){
        return this.count;
    }

    public boolean getCounterVisibility(){
        return this.isCounterVisible;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setIcon(int icon){
        this.icon = icon;
    }

    public void setCount(String count){
        this.count = count;
    }

    public void setCounterVisibility(boolean isCounterVisible){
        this.isCounterVisible = isCounterVisible;
    }
    public boolean isSpinner() {
        return isSpinner;
    }
    public boolean isCover() {
        return isCover;
    }
    public String getDrawerTitle() {
        return drawerTitle;
    }

    public void setDrawerTitle(String drawerTitle) {
        this.drawerTitle = drawerTitle;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(int userAvatar) {
        this.userAvatar = userAvatar;
    }
}
