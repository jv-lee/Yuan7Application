package com.yuan7.tomcat.entity;

/**
 * Created by Administrator on 2017/8/25.
 */

public class ShopBannerEntity {
    private int id;
    private String title;
    private String imageUrl;

    public ShopBannerEntity(int id, String title, String imageUrl) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
