package com.yuan7.tomcat.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2017/8/15.
 */

public class NewsEntity implements MultiItemEntity {
    private int id;
    private String title;
    private String timeStr;
    private String appName;
    private int likeCount;
    private String[] imageUrls;
    private int itemType;

    public static final int SIGNLE = 1;
    public static final int MULTI = 2;

    public NewsEntity(int id, String title, String timeStr, String appName, int likeCount, String[] imageUrls, int itemType) {
        this.id = id;
        this.title = title;
        this.timeStr = timeStr;
        this.appName = appName;
        this.likeCount = likeCount;
        this.imageUrls = imageUrls;
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public static int getSIGNLE() {
        return SIGNLE;
    }

    public static int getMULTI() {
        return MULTI;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
