package com.yuan7.tomcat.entity.impl;

/**
 * Created by Administrator on 2017/9/11.
 */

public class MessageEntity {

    /**
     * id : 3
     * message : 赞了我一下
     * msgType : 2
     * msgTime : 1504752615000
     * state : false
     * userId : 19
     * interactId :
     * interactUser : {"id":20,"userName":"zhangdudu","name":"","sex":false,"image":"","email":"","phone":"","glob":0,"anonymous":false,"level":4,"address":"","createTime":"","birthday":"","deleteFlag":""}
     */

    private Integer id;
    private String message;
    private Integer msgType;
    private long msgTime;
    private boolean state;
    private Integer userId;
    private String interactId;
    private InteractUserBean interactUser;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType( Integer msgType) {
        this.msgType = msgType;
    }

    public long getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(long msgTime) {
        this.msgTime = msgTime;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId( Integer userId) {
        this.userId = userId;
    }

    public String getInteractId() {
        return interactId;
    }

    public void setInteractId(String interactId) {
        this.interactId = interactId;
    }

    public InteractUserBean getInteractUser() {
        return interactUser;
    }

    public void setInteractUser(InteractUserBean interactUser) {
        this.interactUser = interactUser;
    }

    public static class InteractUserBean {
        /**
         * id : 20
         * userName : zhangdudu
         * name :
         * sex : false
         * image :
         * email :
         * phone :
         * glob : 0.0
         * anonymous : false
         * level : 4
         * address :
         * createTime :
         * birthday :
         * deleteFlag :
         */

        private Integer id;
        private String userName;
        private String name;
        private boolean sex;
        private String image;
        private String email;
        private String phone;
        private double glob;
        private boolean anonymous;
        private Integer level;
        private String address;
        private String createTime;
        private String birthday;
        private String deleteFlag;

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
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

        public Integer getLevel() {
            return level;
        }

        public void setLevel( Integer level) {
            this.level = level;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(String deleteFlag) {
            this.deleteFlag = deleteFlag;
        }
    }
}
