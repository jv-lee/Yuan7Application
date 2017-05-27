package com.yuan7.tomcat.bean.impl;


import com.yuan7.tomcat.bean.BaseBean;

import java.util.List;

/**
 * Created by Ly on 2017/5/4.
 * 详情页面
 */

public class DetailBean extends BaseBean {

    /**
     * imgUrl : catServer/
     * dlUrl : catServer/download.action?id=14
     * size : null
     * addTime : 2017-04-30 08:24
     * downloadTimes : 0
     * appImgs : []
     * id : 14
     * source :
     * title : 推荐1
     * content :
     * desc :
     * clickTimes : 0
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String imgUrl;
        private String appName;
        private String dlUrl;
        private long size;
        private String addTime;
        private String downloadTimes;
        private String id;
        private String source;
        private String title;
        private String content;
        private String desc;
        private String clickTimes;
        private String appScore;
        private String appType;
        private List<String> appImgs;


        public String getAppName() {
            return appName;
        }

        public String getAppScore() {
            return appScore;
        }

        public String getAppType() {
            return appType;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
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

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getClickTimes() {
            return clickTimes;
        }

        public void setClickTimes(String clickTimes) {
            this.clickTimes = clickTimes;
        }

        public List<String> getAppImgs() {
            return appImgs;
        }

        public void setAppImgs(List<String > appImgs) {
            this.appImgs = appImgs;
        }
    }
}
