package com.yuan7.tomcat.bean.impl;


import com.yuan7.tomcat.bean.BaseBean;

import java.util.List;

/**
 * Created by Ly on 2017/5/17.
 */

public class HotAdBean extends BaseBean {

    /**
     * result : [{"addTime":"2017-05-08 16:00","source":"豌豆荚","title":"汤姆猫的摩托艇","type":"3","otherUrl":"","clickTimes":0,"imgUrl":"catServer/upload/images/abb9e401-5197-42ab-851c-b07bbaa1659c.png","addType":null,"contentUrl":"catServer/content.action?id=96","vedioUrl":"catServer/upload/files/17f240e7-6ae2-45bb-a3a6-dca76db29870.apk","dlUrl":"catServer/download.action?id=96","size":28914451,"downloadTimes":0,"id":96,"desc":"跳上摩托艇，会说话的汤姆或会说话的安吉拉与你相伴，体验最令人心潮澎湃的水上运动 "}]
     * pageCount :
     * pageNo :
     * pageSize :
     */

    private String pageCount;
    private String pageNo;
    private String pageSize;
    /**
     * addTime : 2017-05-08 16:00
     * source : 豌豆荚
     * title : 汤姆猫的摩托艇
     * type : 3
     * otherUrl :
     * clickTimes : 0
     * imgUrl : catServer/upload/images/abb9e401-5197-42ab-851c-b07bbaa1659c.png
     * addType : null
     * contentUrl : catServer/content.action?id=96
     * vedioUrl : catServer/upload/files/17f240e7-6ae2-45bb-a3a6-dca76db29870.apk
     * dlUrl : catServer/download.action?id=96
     * size : 28914451
     * downloadTimes : 0
     * id : 96
     * desc : 跳上摩托艇，会说话的汤姆或会说话的安吉拉与你相伴，体验最令人心潮澎湃的水上运动
     */

    private List<ResultBean> result;

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
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
        private String otherUrl;
        private int clickTimes;
        private String imgUrl;
        private Object addType;
        private String contentUrl;
        private String vedioUrl;
        private String dlUrl;
        private int size;
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

        public String getOtherUrl() {
            return otherUrl;
        }

        public void setOtherUrl(String otherUrl) {
            this.otherUrl = otherUrl;
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

        public Object getAddType() {
            return addType;
        }

        public void setAddType(Object addType) {
            this.addType = addType;
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

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
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
