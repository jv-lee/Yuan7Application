package com.yuan7.tomcat.entity;

/**
 * Created by Administrator on 2017/8/18.
 */

public class FirandEntity {
    private int id;
    private String name;
    private String iconUrl;
    private int level;

    public FirandEntity(int id, String name, String iconUrl, int level) {
        this.id = id;
        this.name = name;
        this.iconUrl = iconUrl;
        this.level = level;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
