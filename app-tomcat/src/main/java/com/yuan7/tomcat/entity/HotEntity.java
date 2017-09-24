package com.yuan7.tomcat.entity;

/**
 * Created by Administrator on 2017/8/15.
 */

public class HotEntity {

    private int id;
    private String title;
    private String timeStr;
    private int readCount;
    private int inputCount;
    private int niceCount;
    private String imageUrl;

    public HotEntity(int id, String title, String timeStr, int readCount, int inputCount, int niceCount, String imageUrl) {
        this.id = id;
        this.title = title;
        this.timeStr = timeStr;
        this.readCount = readCount;
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

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
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
