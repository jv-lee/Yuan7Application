package com.yuan7.tomcat.bean.impl;


import com.yuan7.tomcat.bean.BaseBean;

import java.util.List;

/**
 * Created by Ly on 2017/4/29.
 * 新闻内容
 */

public class NewsBean extends BaseBean {

    /**
     * result : [{"addTime":"2017-04-30 08:21","source":"","title":"最新内容","type":"1","clickTimes":0,"imgUrl":"catServer/","contentUrl":"catServer/content.action?id=11","vedioUrl":"","dlUrl":"catServer/download.action?id=11","size":null,"downloadTimes":0,"id":11,"desc":""}]
     * pageCount : 1
     * pageNo : 1
     * pageSize : 5
     */

    private int pageCount;
    private String pageNo;
    private String pageSize;
    /**
     * addTime : 2017-04-30 08:21
     * source :
     * title : 最新内容
     * type : 1
     * clickTimes : 0
     * imgUrl : catServer/
     * contentUrl : catServer/content.action?id=11
     * vedioUrl :
     * dlUrl : catServer/download.action?id=11
     * size : null
     * downloadTimes : 0
     * id : 11
     * desc :
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
        private String source;
        private String title;
        private String type;
        private int clickTimes;
        private String imgUrl;
        private String contentUrl;
        private String vedioUrl;
        private String dlUrl;
        private Object size;
        private int downloadTimes;
        private int id;
        private String desc;
        private String appName;

        public String getAppName() {
            return appName;
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

        public int getClickTimes() {
            return clickTimes;
        }

        public void setClickTimes(int clickTimes) {
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

        public Object getSize() {
            return size;
        }

        public void setSize(Object size) {
            this.size = size;
        }

        public int getDownloadTimes() {
            return downloadTimes;
        }

        public void setDownloadTimes(int downloadTimes) {
            this.downloadTimes = downloadTimes;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
