package com.yuan7.tomcat.bean.impl;


import com.yuan7.tomcat.bean.BaseBean;

import java.util.List;

/**
 * Created by Ly on 2017/4/29.
 * 轮播图实体类
 */

public class BannerBean extends BaseBean {


    /**
     * result : [{"addTime":"2017-04-30 02:14","source":"百度","title":"轮播图1","type":"1","clickTimes":0,"imgUrl":"catServer//upload/images/9b303721-f8fd-477b-a748-80c2655977b5.png","contentUrl":"catServer/content.action?id=3","vedioUrl":"/upload/files/test.txt","dlUrl":"catServer/download.action?id=3","size":null,"downloadTimes":0,"id":3,"desc":"fewf"},{"addTime":"2017-04-30 02:14","source":"","title":"轮播图2","type":"2","clickTimes":0,"imgUrl":"catServer//upload/images/0b323578-ca19-4960-947f-84152fdf10da.png","contentUrl":"catServer/content.action?id=5","vedioUrl":"","dlUrl":"catServer/download.action?id=5","size":null,"downloadTimes":0,"id":5,"desc":"fewf"},{"addTime":"2017-04-30 02:14","source":"","title":"轮播图3","type":"1","clickTimes":0,"imgUrl":"catServer//upload/images/3bc24151-bc38-45a1-8a3e-c070905c526d.png","contentUrl":"catServer/content.action?id=6","vedioUrl":"","dlUrl":"catServer/download.action?id=6","size":null,"downloadTimes":0,"id":6,"desc":"fewf"},{"addTime":"2017-04-30 02:14","source":"","title":"轮播图4","type":"1","clickTimes":0,"imgUrl":"catServer//upload/images/939bfa1c-f071-4b35-82e3-8ed2f6aaf07b.png","contentUrl":"catServer/content.action?id=7","vedioUrl":"/upload/files/62846e10-4431-4c6d-aeb5-b86c2852a9a9.apk","dlUrl":"catServer/download.action?id=7","size":null,"downloadTimes":0,"id":7,"desc":""},{"addTime":"2017-04-30 02:14","source":"","title":"轮播图5","type":"1","clickTimes":0,"imgUrl":"catServer/","contentUrl":"catServer/content.action?id=8","vedioUrl":"/upload/files/069dd145-02e5-482d-bfba-5bd8b81f5c89.apk","dlUrl":"catServer/download.action?id=8","size":null,"downloadTimes":0,"id":8,"desc":""},{"addTime":"2017-04-30 02:14","source":"","title":"ttttttaaaa","type":"1","clickTimes":0,"imgUrl":"catServer/","contentUrl":"catServer/content.action?id=9","vedioUrl":"/upload/files/a8c33f31-da6f-493b-8218-50fc7f99f404.apk","dlUrl":"catServer/download.action?id=9","size":null,"downloadTimes":0,"id":9,"desc":""}]
     * pageCount : 1
     * pageNo : 1
     * pageSize : 10
     */

    private String pageCount;
    private String pageNo;
    private String pageSize;
    /**
     * addTime : 2017-04-30 02:14
     * source : 百度
     * title : 轮播图1
     * type : 1
     * clickTimes : 0
     * imgUrl : catServer//upload/images/9b303721-f8fd-477b-a748-80c2655977b5.png
     * contentUrl : catServer/content.action?id=3
     * vedioUrl : /upload/files/test.txt
     * dlUrl : catServer/download.action?id=3
     * size : null
     * downloadTimes : 0
     * id : 3
     * desc : fewf
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
        private int clickTimes;
        private String imgUrl;
        private String contentUrl;
        private String vedioUrl;
        private String dlUrl;
        private Object size;
        private int downloadTimes;
        private int id;
        private String desc;
        private String otherUrl;
        private String appName;

        public String getAppName() {
            return appName;
        }

        public String getOtherUrl() {
            return otherUrl;
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
