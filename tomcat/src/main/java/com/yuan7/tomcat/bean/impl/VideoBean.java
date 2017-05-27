package com.yuan7.tomcat.bean.impl;


import com.yuan7.tomcat.bean.BaseBean;

import java.util.List;

/**
 * Created by Ly on 2017/4/29.
 * 获取视频
 */

public class VideoBean extends BaseBean {


    /**
     * result : [{"addTime":"2017-04-30 08:24","source":"未知","title":"会说话的汤姆猫","type":"3","clickTimes":0,"imgUrl":"catServer//upload/images/bdfa6f56-5b9e-43e4-975a-ec71e8a62c65.jpg","contentUrl":"catServer/content.action?id=14","vedioUrl":"","dlUrl":"catServer/download.action?id=14","size":null,"downloadTimes":0,"id":14,"desc":"超可爱的宠物养成游戏"}]
     * pageCount : 1
     * pageNo : 1
     * pageSize : 10
     */

    private int pageCount;
    private String pageNo;
    private String pageSize;
    /**
     * addTime : 2017-04-30 08:24
     * source : 未知
     * title : 会说话的汤姆猫
     * type : 3
     * clickTimes : 0
     * imgUrl : catServer//upload/images/bdfa6f56-5b9e-43e4-975a-ec71e8a62c65.jpg
     * contentUrl : catServer/content.action?id=14
     * vedioUrl :
     * dlUrl : catServer/download.action?id=14
     * size : null
     * downloadTimes : 0
     * id : 14
     * desc : 超可爱的宠物养成游戏
     */

    private List<ResultBean> result;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String addTime;
        private String appName;
        private String source;
        private String title;
        private String type;
        private String clickTimes;
        private String imgUrl;
        private String contentUrl;
        private String vedioUrl;
        private String dlUrl;
        private long size;
        private String downloadTimes;
        private String id;
        private String desc;
        private String appScore;
        private String addType;

        public String getAppType() {
            return addType;
        }

        public String getAppScore() {
            return appScore;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getClickTimes() {
            return clickTimes;
        }

        public void setClickTimes(String clickTimes) {
            this.clickTimes = clickTimes;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getContentUrl() {
            return contentUrl;
        }

        public void setContentUrl(String contentUrl) {
            this.contentUrl = contentUrl;
        }

        public String getVedioUrl() {
            return vedioUrl;
        }

        public void setVedioUrl(String vedioUrl) {
            this.vedioUrl = vedioUrl;
        }

        public String getDlUrl() {
            return dlUrl;
        }

        public void setDlUrl(String dlUrl) {
            this.dlUrl = dlUrl;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public String getDownloadTimes() {
            return downloadTimes;
        }

        public void setDownloadTimes(String downloadTimes) {
            this.downloadTimes = downloadTimes;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getAppName() {
            return appName;
        }
    }
}
