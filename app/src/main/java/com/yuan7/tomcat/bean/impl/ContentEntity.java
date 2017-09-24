package com.yuan7.tomcat.bean.impl;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.yuan7.tomcat.bean.ImageEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */

public class ContentEntity implements MultiItemEntity {

    private Integer id;
    private String title;
    private String briefIntroduction;
    private String author;
    private String source;
    private String sourceUrl;
    private Integer sourceType;
    private boolean urlType;
    private Integer viewTimes;
    private Integer gootRate;
    private Integer poorRate;
    private Integer commentRate;
    private String state;
    private String editeTime;
    private Integer size;
    private long creatTime;
    private List<ImageEntity> images;

    public static final int SIGNLE = 1;
    public static final int MULTI = 2;
    public static final int COMM_TEXT = 3;
    public static final int COMM_VIDEO = 4;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType( Integer sourceType) {
        this.sourceType = sourceType;
    }

    public boolean isUrlType() {
        return urlType;
    }

    public void setUrlType(boolean urlType) {
        this.urlType = urlType;
    }

    public Integer getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes( Integer viewTimes) {
        this.viewTimes = viewTimes;
    }

    public Integer getGootRate() {
        return gootRate;
    }

    public void setGootRate( Integer gootRate) {
        this.gootRate = gootRate;
    }

    public Integer getPoorRate() {
        return poorRate;
    }

    public void setPoorRate( Integer poorRate) {
        this.poorRate = poorRate;
    }

    public Integer getCommentRate() {
        return commentRate;
    }

    public void setCommentRate( Integer commentRate) {
        this.commentRate = commentRate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEditeTime() {
        return editeTime;
    }

    public void setEditeTime(String editeTime) {
        this.editeTime = editeTime;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize( Integer size) {
        this.size = size;
    }

    public long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(long creatTime) {
        this.creatTime = creatTime;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }

    @Override
    public int getItemType() {
        if (sourceType == 0) {
            return COMM_VIDEO;
        } else {
            return size > 1 ? 2 : 1;
        }
    }
}
