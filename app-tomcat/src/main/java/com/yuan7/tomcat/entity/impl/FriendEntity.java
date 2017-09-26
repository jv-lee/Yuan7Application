package com.yuan7.tomcat.entity.impl;

/**
 * Created by Administrator on 2017/9/7.
 */

public class FriendEntity {


    /**
     * id : 21
     * userName : zh
     * name : 昵称
     * sex : true
     * image : 用户头像
     * level : 1
     * createTime : null
     * birthday : null
     * friendFlag : true
     * newsNum : 2
     * goodNum : 0
     * friendCount : 2
     * empirical : 0
     * levelname : 0
     */

    private Integer id;
    private String userName;
    private String name;
    private boolean sex;
    private String image;
    private Integer level;
    private Object createTime;
    private Object birthday;
    private boolean friendFlag;
    private Integer newsNum;
    private Integer goodNum;
    private Integer friendCount;
    private Integer empirical;
    private String levelname;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id) {
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel( Integer level) {
        this.level = level;
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

    public boolean isFriendFlag() {
        return friendFlag;
    }

    public void setFriendFlag(boolean friendFlag) {
        this.friendFlag = friendFlag;
    }

    public Integer getNewsNum() {
        return newsNum;
    }

    public void setNewsNum( Integer newsNum) {
        this.newsNum = newsNum;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum( Integer goodNum) {
        this.goodNum = goodNum;
    }

    public Integer getFriendCount() {
        return friendCount;
    }

    public void setFriendCount( Integer friendCount) {
        this.friendCount = friendCount;
    }

    public Integer getEmpirical() {
        return empirical;
    }

    public void setEmpirical( Integer empirical) {
        this.empirical = empirical;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }
}
