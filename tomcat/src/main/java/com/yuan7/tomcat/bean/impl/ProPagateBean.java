package com.yuan7.tomcat.bean.impl;


import com.yuan7.tomcat.bean.BaseBean;

import java.util.List;

/**
 * Created by Ly on 2017/4/29.
 * 宣传图
 */

public class ProPagateBean extends BaseBean {

    /**
     * id : 1
     * title : test
     * imgUrl : server/test.jpg
     * type : 1
     * contentUrl : server/content.action?id=1
     * dlUrl : server/download.action?id=1
     * status : 200
     */

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String id;
        private String title;
        private String imgUrl;
        private String type;
        private String contentUrl;
        private String dlUrl;
        private String status;
        private String vedioUrl;
        private String otherUrl;
        private String appName;

        public String getAppName() {
            return appName;
        }

        public String getOtherUrl() {
            return otherUrl;
        }

        public String getVedioUrl() {
            return vedioUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContentUrl() {
            return contentUrl;
        }

        public void setContentUrl(String contentUrl) {
            this.contentUrl = contentUrl;
        }

        public String getDlUrl() {
            return dlUrl;
        }

        public void setDlUrl(String dlUrl) {
            this.dlUrl = dlUrl;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
