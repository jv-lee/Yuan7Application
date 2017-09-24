package com.yuan7.tomcat.bean.impl;

/**
 * Created by Administrator on 2017/9/12.
 */

public class SettingsUserEntity {

    /**
     * code : 2000
     * message : 修改app用户成功
     * obj : {"id":19,"userName":"test123456","name":"你好啊","sex":false,"image":"http://yuan7ad.oss-cn-shenzhen.aliyuncs.com/userData/user/image/1505214562389.jpg","email":"","phone":"","glob":0,"anonymous":false,"level":3,"address":"","createTime":"","birthday":"","deleteFlag":false}
     */

    private Integer code;
    private String message;
    private ObjBean obj;

    public Integer getCode() {
        return code;
    }

    public void setCode( Integer code) {
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
         * id : 19
         * userName : test123456
         * name : 你好啊
         * sex : false
         * image : http://yuan7ad.oss-cn-shenzhen.aliyuncs.com/userData/user/image/1505214562389.jpg
         * email :
         * phone :
         * glob : 0.0
         * anonymous : false
         * level : 3
         * address :
         * createTime :
         * birthday :
         * deleteFlag : false
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
        private boolean deleteFlag;
        private Integer empirical;
        private String levelname;

        public Integer getEmpirical() {
            return empirical;
        }

        public void setEmpirical(Integer empirical) {
            this.empirical = empirical;
        }

        public String getLevelname() {
            return levelname;
        }

        public void setLevelname(String levelname) {
            this.levelname = levelname;
        }

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

        public boolean isDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(boolean deleteFlag) {
            this.deleteFlag = deleteFlag;
        }
    }
}
