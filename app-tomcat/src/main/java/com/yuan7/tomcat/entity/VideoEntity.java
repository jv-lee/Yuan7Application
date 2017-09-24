package com.yuan7.tomcat.entity;

/**
 * Created by Administrator on 2017/8/15.
 */

public class VideoEntity {
    private int id;
    private String title;
    private String content;
    private int inputCount;
    private int niceCount;
    private String imageUrl;

    public VideoEntity(int id, String title, String content, int inputCount, int niceCount, String imageUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.inputCount = inputCount;
        this.niceCount = niceCount;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getInputCount() {
        return inputCount;
    }

    public void setInputCount(int inputCount) {
        this.inputCount = inputCount;
    }

    public int getNiceCount() {
        return niceCount;
    }

    public void setNiceCount(int niceCount) {
        this.niceCount = niceCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
