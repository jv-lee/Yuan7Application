package com.yuan7.tomcat.bean.impl;

import java.util.List;

/**
 * Created by Administrator on 2017/9/11.
 */

public class PostEntity {


    /**
     * id : 557
     * title : 早间新闻
     * briefIntroduction : 这是一个早间新闻
     * author : 张三
     * source : web
     * sourceUrl : www.baidu.com
     * sourceType : 0
     * urlType : false
     * viewTimes : 0
     * gootRate : 0
     * poorRate : 0
     * commentRate : 0
     * photos :
     * state : 0
     * editeTime :
     * content :
     * creatTime : 2017-08-30 03:10:38
     * deleteFlag : false
     * userId : 19
     * user :
     * images : [{"id":111,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}]
     * size : 1
     */

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
    private String photos;
    private String state;
    private String editeTime;
    private String content;
    private String creatTime;
    private boolean deleteFlag;
    private Integer userId;
    private String user;
    private Integer size;
    private List<ImagesBean> images;

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

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId( Integer userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize( Integer size) {
        this.size = size;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class ImagesBean {
        /**
         * id : 111
         * url : http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg
         * type : 0
         * size : 10
         * newsId :
         */

        private Integer id;
        private String url;
        private Integer type;
        private Integer size;
        private String newsId;

        public Integer getId() {
            return id;
        }

        public void setId( Integer id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getType() {
            return type;
        }

        public void setType( Integer type) {
            this.type = type;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize( Integer size) {
            this.size = size;
        }

        public String getNewsId() {
            return newsId;
        }

        public void setNewsId(String newsId) {
            this.newsId = newsId;
        }
    }
}
