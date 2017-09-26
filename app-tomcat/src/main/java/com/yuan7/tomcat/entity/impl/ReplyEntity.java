package com.yuan7.tomcat.entity.impl;

import java.util.List;

/**
 * Created by Administrator on 2017/9/11.
 */

public class ReplyEntity {


    /**
     * commentId : 1356
     * commentContent : 我搜搜哦
     * commentDate : 1504907649000
     * commentGoodNum : 1
     * commentPoorNum : 0
     * commentViewNum : 122
     * commentCommentNum : 0
     * newsId : 713
     * source : web
     * sourceUrl : www.baidu.com
     * sourceType : 0
     * urlType : false
     * briefIntroduction : 这是一个早间新闻
     * size : 1
     * content :
     * images : [{"id":151,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}]
     * newsTitle : 早间新闻
     * newsGoodNum : 0
     * newsPoorNum : 0
     * newsViewNum : 0
     * newsCommentNum : 1
     * viewTimes :
     * gootRate :
     * poorRate :
     * commentRate :
     */

    private Integer commentId;
    private String commentContent;
    private long commentDate;
    private Integer commentGoodNum;
    private Integer commentPoorNum;
    private Integer commentViewNum;
    private Integer commentCommentNum;
    private Integer newsId;
    private String source;
    private String sourceUrl;
    private Integer sourceType;
    private boolean urlType;
    private String briefIntroduction;
    private Integer size;
    private String content;
    private String newsTitle;
    private Integer newsGoodNum;
    private Integer newsPoorNum;
    private Integer newsViewNum;
    private Integer newsCommentNum;
    private String viewTimes;
    private String gootRate;
    private String poorRate;
    private String commentRate;
    private List<ImagesBean> images;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId( Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public long getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(long commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getCommentGoodNum() {
        return commentGoodNum;
    }

    public void setCommentGoodNum( Integer commentGoodNum) {
        this.commentGoodNum = commentGoodNum;
    }

    public Integer getCommentPoorNum() {
        return commentPoorNum;
    }

    public void setCommentPoorNum( Integer commentPoorNum) {
        this.commentPoorNum = commentPoorNum;
    }

    public Integer getCommentViewNum() {
        return commentViewNum;
    }

    public void setCommentViewNum( Integer commentViewNum) {
        this.commentViewNum = commentViewNum;
    }

    public Integer getCommentCommentNum() {
        return commentCommentNum;
    }

    public void setCommentCommentNum( Integer commentCommentNum) {
        this.commentCommentNum = commentCommentNum;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId( Integer newsId) {
        this.newsId = newsId;
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

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize( Integer size) {
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public Integer getNewsGoodNum() {
        return newsGoodNum;
    }

    public void setNewsGoodNum( Integer newsGoodNum) {
        this.newsGoodNum = newsGoodNum;
    }

    public Integer getNewsPoorNum() {
        return newsPoorNum;
    }

    public void setNewsPoorNum( Integer newsPoorNum) {
        this.newsPoorNum = newsPoorNum;
    }

    public Integer getNewsViewNum() {
        return newsViewNum;
    }

    public void setNewsViewNum( Integer newsViewNum) {
        this.newsViewNum = newsViewNum;
    }

    public Integer getNewsCommentNum() {
        return newsCommentNum;
    }

    public void setNewsCommentNum( Integer newsCommentNum) {
        this.newsCommentNum = newsCommentNum;
    }

    public String getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes(String viewTimes) {
        this.viewTimes = viewTimes;
    }

    public String getGootRate() {
        return gootRate;
    }

    public void setGootRate(String gootRate) {
        this.gootRate = gootRate;
    }

    public String getPoorRate() {
        return poorRate;
    }

    public void setPoorRate(String poorRate) {
        this.poorRate = poorRate;
    }

    public String getCommentRate() {
        return commentRate;
    }

    public void setCommentRate(String commentRate) {
        this.commentRate = commentRate;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class ImagesBean {
        /**
         * id : 151
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
