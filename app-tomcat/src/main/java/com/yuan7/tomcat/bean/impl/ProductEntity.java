package com.yuan7.tomcat.bean.impl;

import com.yuan7.tomcat.bean.ImageEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */

public class ProductEntity {


    /**
     * id : 1018
     * title : 加速道具
     * briefIntroduction : 速度提升
     * description : 可兑换
     * viewTimes : 0
     * gootRate : 0
     * poorRate : 0
     * commentRate : 1
     * photos :
     * price : 100.0
     * stock : 0
     * state : 1
     * editeTime : 2017-09-14 17:38:20
     * creatTime : 2017-09-14 11:28:38
     * deleteflag : false
     * userid : 1
     * classify : hot
     * content : 飞速升级
     */

    private Integer id;
    private String title;
    private String briefIntroduction;
    private String description;
    private Integer viewTimes;
    private Integer gootRate;
    private Integer poorRate;
    private Integer commentRate;
    private String photos;
    private Integer price;
    private Integer stock;
    private String state;
    private String editeTime;
    private String creatTime;
    private boolean deleteflag;
    private Integer userid;
    private String classify;
    private String content;
    private Integer count;
    private List<ImageEntity> images;

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes(Integer viewTimes) {
        this.viewTimes = viewTimes;
    }

    public Integer getGootRate() {
        return gootRate;
    }

    public void setGootRate(Integer gootRate) {
        this.gootRate = gootRate;
    }

    public Integer getPoorRate() {
        return poorRate;
    }

    public void setPoorRate(Integer poorRate) {
        this.poorRate = poorRate;
    }

    public Integer getCommentRate() {
        return commentRate;
    }

    public void setCommentRate(Integer commentRate) {
        this.commentRate = commentRate;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
