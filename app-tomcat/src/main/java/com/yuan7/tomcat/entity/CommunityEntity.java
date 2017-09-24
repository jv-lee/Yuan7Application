package com.yuan7.tomcat.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2017/8/18.
 */

public class CommunityEntity implements MultiItemEntity {
    private int id;
    private String name;
    private String dateStr;
    private int level;
    private String levelStr;
    private String contentMessage;
    private String[] imageUrls;
    private String videoUrl;
    private String videoTitle;
    private String videoPic;
    private int readCount;
    private int inputCount;
    private int niceCount;
    private String iconUrl;
    private int itemType;

    public static final int IMAGE = 1;
    public static final int VIDEO = 2;

    public CommunityEntity(int id, String name, String dateStr, int level, String levelStr, String contentMessage, String[] imageUrls, String videoUrl, String videoTitle, String videoPic, int readCount, int inputCount, int niceCount, String iconUrl, int itemType) {
        this.id = id;
        this.name = name;
        this.dateStr = dateStr;
        this.level = level;
        this.levelStr = levelStr;
        this.contentMessage = contentMessage;
        this.imageUrls = imageUrls;
        this.videoUrl = videoUrl;
        this.videoTitle = videoTitle;
        this.videoPic = videoPic;
        this.readCount = readCount;
        this.inputCount = inputCount;
        this.niceCount = niceCount;
        this.iconUrl = iconUrl;
        this.itemType = itemType;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLevelStr() {
        return levelStr;
    }

    public void setLevelStr(String levelStr) {
        this.levelStr = levelStr;
    }

    public String getContentMessage() {
        return contentMessage;
    }

    public void setContentMessage(String contentMessage) {
        this.contentMessage = contentMessage;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoPic() {
        return videoPic;
    }

    public void setVideoPic(String videoPic) {
        this.videoPic = videoPic;
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

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public static int getIMAGE() {
        return IMAGE;
    }

    public static int getVIDEO() {
        return VIDEO;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
