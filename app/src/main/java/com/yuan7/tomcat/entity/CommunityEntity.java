package com.yuan7.tomcat.entity;

/**
 * Created by Administrator on 2017/8/18.
 */

public class CommunityEntity {
    private int id;
    private String name;
    private String dateStr;
    private String deviceSource;
    private String contentMessage;
    private boolean followFlag;
    private String[] imageUrls;
    private int readCount;
    private int inputCount;
    private int niceCount;
    private String iconUrl;

    public CommunityEntity(int id, String name, String dateStr, String deviceSource, String contentMessage, boolean followFlag, String[] imageUrls, int readCount, int inputCount, int niceCount, String iconUrl) {
        this.id = id;
        this.name = name;
        this.dateStr = dateStr;
        this.deviceSource = deviceSource;
        this.contentMessage = contentMessage;
        this.followFlag = followFlag;
        this.imageUrls = imageUrls;
        this.readCount = readCount;
        this.inputCount = inputCount;
        this.niceCount = niceCount;
        this.iconUrl = iconUrl;
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

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getDeviceSource() {
        return deviceSource;
    }

    public void setDeviceSource(String deviceSource) {
        this.deviceSource = deviceSource;
    }

    public String getContentMessage() {
        return contentMessage;
    }

    public void setContentMessage(String contentMessage) {
        this.contentMessage = contentMessage;
    }

    public boolean isFollowFlag() {
        return followFlag;
    }

    public void setFollowFlag(boolean followFlag) {
        this.followFlag = followFlag;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
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

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
