package com.yuan7.tomcat.bean.impl;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class SearchEntity {


    /**
     * size : 1
     * id : 1195
     * user : {"id":1,"userName":"newsUser123","name":null,"sex":false,"image":null,"email":null,"phone":null,"glob":0,"anonymous":false,"level":2,"address":null,"createTime":null,"birthday":null,"deleteFlag":false,"empirical":null,"levelname":null}
     * title : 会说话的汤姆猫——演唱神曲忐忑
     * briefIntroduction : 《忐忑》被誉为神曲，不过今天我们的主角汤姆猫来挑战神曲《忐忑》，让我们拭目以待吧！
     * author : 未知
     * source : 未知
     * sourceUrl : http://f.v.17173cdn.com/player_f2/NjgzNTgwNg.swf
     * sourceType : 0
     * urlType : true
     * viewTimes : 0
     * gootRate : 0
     * poorRate : 0
     * commentRate : 7
     * images : [{"id":1251,"url":"http://yuan7ad.oss-cn-shenzhen.aliyuncs.com/newsData/news/photo/1505724304028.jpg","type":0,"size":0,"newsId":null}]
     * state : 1
     * editeTime : 1505734958000
     * creatTime : 1505695521000
     */

    private int size;
    private int id;
    private UserBean user;
    private String title;
    private String briefIntroduction;
    private String author;
    private String source;
    private String sourceUrl;
    private int sourceType;
    private boolean urlType;
    private int viewTimes;
    private int gootRate;
    private int poorRate;
    private int commentRate;
    private String state;
    private long editeTime;
    private long creatTime;
    private List<ImagesBean> images;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
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

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public boolean isUrlType() {
        return urlType;
    }

    public void setUrlType(boolean urlType) {
        this.urlType = urlType;
    }

    public int getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes(int viewTimes) {
        this.viewTimes = viewTimes;
    }

    public int getGootRate() {
        return gootRate;
    }

    public void setGootRate(int gootRate) {
        this.gootRate = gootRate;
    }

    public int getPoorRate() {
        return poorRate;
    }

    public void setPoorRate(int poorRate) {
        this.poorRate = poorRate;
    }

    public int getCommentRate() {
        return commentRate;
    }

    public void setCommentRate(int commentRate) {
        this.commentRate = commentRate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getEditeTime() {
        return editeTime;
    }

    public void setEditeTime(long editeTime) {
        this.editeTime = editeTime;
    }

    public long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(long creatTime) {
        this.creatTime = creatTime;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class UserBean {
        /**
         * id : 1
         * userName : newsUser123
         * name : null
         * sex : false
         * image : null
         * email : null
         * phone : null
         * glob : 0.0
         * anonymous : false
         * level : 2
         * address : null
         * createTime : null
         * birthday : null
         * deleteFlag : false
         * empirical : null
         * levelname : null
         */

        private int id;
        private String userName;
        private Object name;
        private boolean sex;
        private Object image;
        private Object email;
        private Object phone;
        private double glob;
        private boolean anonymous;
        private int level;
        private Object address;
        private Object createTime;
        private Object birthday;
        private boolean deleteFlag;
        private Object empirical;
        private Object levelname;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public double getGlob() {
            return glob;
        }

        public void setGlob(double glob) {
            this.glob = glob;
        }

        public boolean isAnonymous() {
            return anonymous;
        }

        public void setAnonymous(boolean anonymous) {
            this.anonymous = anonymous;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public boolean isDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(boolean deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public Object getEmpirical() {
            return empirical;
        }

        public void setEmpirical(Object empirical) {
            this.empirical = empirical;
        }

        public Object getLevelname() {
            return levelname;
        }

        public void setLevelname(Object levelname) {
            this.levelname = levelname;
        }
    }

    public static class ImagesBean {
        /**
         * id : 1251
         * url : http://yuan7ad.oss-cn-shenzhen.aliyuncs.com/newsData/news/photo/1505724304028.jpg
         * type : 0
         * size : 0
         * newsId : null
         */

        private int id;
        private String url;
        private int type;
        private int size;
        private Object newsId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Object getNewsId() {
            return newsId;
        }

        public void setNewsId(Object newsId) {
            this.newsId = newsId;
        }
    }
}
