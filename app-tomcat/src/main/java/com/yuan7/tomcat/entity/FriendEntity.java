package com.yuan7.tomcat.entity;

/**
 * Created by Administrator on 2017/8/18.
 */

public class FriendEntity {
    private int id;
    private String name;
    private String iconUrl;
    private int rankLevel;
    private int userLevel;

    public FriendEntity(int id, String name, String iconUrl, int rankLevel, int userLevel) {
        this.id = id;
        this.name = name;
        this.iconUrl = iconUrl;
        this.rankLevel = rankLevel;
        this.userLevel = userLevel;
    }

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

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getRankLevel() {
        return rankLevel;
    }

    public void setRankLevel(int rankLevel) {
        this.rankLevel = rankLevel;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }
}
