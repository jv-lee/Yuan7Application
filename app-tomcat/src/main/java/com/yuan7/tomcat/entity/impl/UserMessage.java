package com.yuan7.tomcat.entity.impl;

/**
 * Created by Administrator on 2017/9/22.
 */

public class UserMessage {


    /**
     * userId : 19
     * userName : test123456
     * name : 看看
     * sex : false
     * image : http://yuan7ad.oss-cn-shenzhen.aliyuncs.com/userData/user/image/1505987210036.png
     * level : 3
     * friendsNum : 4
     * newsNum : 90
     * unreadMsgNum : 2
     * levelname : 超级汉克
     * invitecode : 456789
     * isinvite : true
     * writecode : 123456
     */

    private Integer userId;
    private String userName;
    private String name;
    private boolean sex;
    private String image;
    private Integer level;
    private Integer friendsNum;
    private Integer newsNum;
    private Integer unreadMsgNum;
    private String levelname;
    private String invitecode;
    private boolean isinvite;
    private String writecode;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId( Integer userId) {
        this.userId = userId;
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

    public Integer getFriendsNum() {
        return friendsNum;
    }

    public void setFriendsNum( Integer friendsNum) {
        this.friendsNum = friendsNum;
    }

    public Integer getNewsNum() {
        return newsNum;
    }

    public void setNewsNum( Integer newsNum) {
        this.newsNum = newsNum;
    }

    public Integer getUnreadMsgNum() {
        return unreadMsgNum;
    }

    public void setUnreadMsgNum( Integer unreadMsgNum) {
        this.unreadMsgNum = unreadMsgNum;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public String getInvitecode() {
        return invitecode;
    }

    public void setInvitecode(String invitecode) {
        this.invitecode = invitecode;
    }

    public boolean isIsinvite() {
        return isinvite;
    }

    public void setIsinvite(boolean isinvite) {
        this.isinvite = isinvite;
    }

    public String getWritecode() {
        return writecode;
    }

    public void setWritecode(String writecode) {
        this.writecode = writecode;
    }
}
