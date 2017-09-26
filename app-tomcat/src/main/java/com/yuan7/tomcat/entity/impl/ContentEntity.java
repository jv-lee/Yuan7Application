package com.yuan7.tomcat.entity.impl;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.yuan7.tomcat.entity.ImageEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */

public class ContentEntity implements MultiItemEntity {

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
    private String state;
    private String editeTime;
    private Integer size;
    private long creatTime;
    private List<ImageEntity> images;
    private User user;
    private Advertisement advertisement;
    private boolean hasAd = false;

    public static final int AD = 6;
    public static final int SIGNLE = 1;
    public static final int MULTI = 2;
    public static final int COMM_TEXT = 3;
    public static final int COMM_VIDEO = 4;

    public boolean isHasAd() {
        return hasAd;
    }

    public void setHasAd(boolean hasAd) {
        this.hasAd = hasAd;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setSourceType(Integer sourceType) {
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

    public void setViewTimes(Integer viewTimes) {
        this.viewTimes = viewTimes;
    }

    public Integer getGootRate() {
        return gootRate;
    }

    public void setGootRate(Integer gootRate) {
        this.gootRate = gootRate;
    }

    public Integer getPoorRate() {
        return poorRate;
    }

    public void setPoorRate(Integer poorRate) {
        this.poorRate = poorRate;
    }

    public Integer getCommentRate() {
        return commentRate;
    }

    public void setCommentRate(Integer commentRate) {
        this.commentRate = commentRate;
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(long creatTime) {
        this.creatTime = creatTime;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }

    @Override
    public int getItemType() {
        if (hasAd) {
            if (advertisement != null) {
                return AD;
            }
        }
        if (sourceType == 0) {
            return COMM_VIDEO;
        } else {
            return size > 1 ? 2 : 1;
        }
    }

    public class Advertisement {

        /**
         * id : 2
         * title : 231
         * priority : 1
         * enabled : true
         * sourceUrl : 2
         * sourceType : 1
         * urltype : 1
         * createtime : 2017-09-12 15:32:52
         * brief : 1
         * images : 1
         * content : 1
         */

        private int id;
        private String title;
        private int priority;
        private boolean enabled;
        private String sourceUrl;
        private int sourceType;
        private int urltype;
        private String createtime;
        private String brief;
        private String images;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
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

        public int getUrltype() {
            return urltype;
        }

        public void setUrltype(int urltype) {
            this.urltype = urltype;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
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
    }

    public class User {


        /**
         * id : 19
         * userName : test123456
         * name : 看看
         * sex : true
         * image : /data/system/theme_magic/customized_icons/com.xiaomi.payment.png
         * email : null
         * phone : null
         * glob : 96990.0
         * anonymous : false
         * level : 3
         * address : 湖南
         * createTime : null
         * birthday : null
         * deleteFlag : false
         * empirical : null
         * levelname : null
         */

        private int id;
        private String userName;
        private String name;
        private boolean sex;
        private String image;
        private Object email;
        private Object phone;
        private double glob;
        private boolean anonymous;
        private int level;
        private String address;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
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
}
