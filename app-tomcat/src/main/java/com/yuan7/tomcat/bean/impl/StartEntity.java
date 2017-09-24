package com.yuan7.tomcat.bean.impl;

/**
 * Created by Administrator on 2017/9/14.
 */

public class StartEntity {

    /**
     * code : 2000
     * message : 加载应用配置成功
     * obj : {"appConfig":{"id":2,"state":0,"appId":2},"promotedApp":{"id":1,"name":"tomcat","bannerimage":"www.baidu.com","images":"adc","content":"tomcat","appId":2,"createTime":"2017-09-14 19:14:35","app":""}}
     */

    private Integer code;
    private String message;
    private ObjBean obj;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * appConfig : {"id":2,"state":0,"appId":2}
         * promotedApp : {"id":1,"name":"tomcat","bannerimage":"www.baidu.com","images":"adc","content":"tomcat","appId":2,"createTime":"2017-09-14 19:14:35","app":""}
         */

        private AppConfigBean appConfig;
        private PromotedAppBean promotedApp;

        public AppConfigBean getAppConfig() {
            return appConfig;
        }

        public void setAppConfig(AppConfigBean appConfig) {
            this.appConfig = appConfig;
        }

        public PromotedAppBean getPromotedApp() {
            return promotedApp;
        }

        public void setPromotedApp(PromotedAppBean promotedApp) {
            this.promotedApp = promotedApp;
        }

        public static class AppConfigBean {
            /**
             * id : 2
             * state : 0
             * appId : 2
             */

            private Integer id;
            private Integer state;
            private Integer appId;
            private Boolean activity;

            public Boolean getActivity() {
                return activity;
            }

            public void setActivity(Boolean activity) {
                this.activity = activity;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getState() {
                return state;
            }

            public void setState(Integer state) {
                this.state = state;
            }

            public Integer getAppId() {
                return appId;
            }

            public void setAppId(Integer appId) {
                this.appId = appId;
            }
        }

        public static class PromotedAppBean {
            /**
             * id : 1
             * name : tomcat
             * bannerimage : www.baidu.com
             * images : adc
             * content : tomcat
             * appId : 2
             * createTime : 2017-09-14 19:14:35
             * app :
             */

            private Integer id;
            private String name;
            private String bannerimage;
            private String images;
            private String content;
            private Integer appId;
            private String createTime;
            private String app;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBannerimage() {
                return bannerimage;
            }

            public void setBannerimage(String bannerimage) {
                this.bannerimage = bannerimage;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public Integer getAppId() {
                return appId;
            }

            public void setAppId(Integer appId) {
                this.appId = appId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getApp() {
                return app;
            }

            public void setApp(String app) {
                this.app = app;
            }
        }
    }
}
