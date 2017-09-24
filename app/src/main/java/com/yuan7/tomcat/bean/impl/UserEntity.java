package com.yuan7.tomcat.bean.impl;

/**
 * Created by Administrator on 2017/9/7.
 */

public class UserEntity {

    /**
     * code : 2000
     * message : 登录成功
     * obj : {"user":{"id":19,"userName":"test123456","name":"","sex":false,"image":"","email":"","phone":"","glob":0,"anonymous":false,"level":3,"address":"","createTime":"","birthday":"","deleteFlag":false},"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJ1c2VySWRcIjoxOSxcInVzZXJuYW1lXCI6XCJ0ZXN0MTIzNDU2XCIsXCJwYXNzd29yZFwiOlwiJDJhJDEwJGZYS2RVS1lCeE80R2RSak5hN1hodk9NV1d2N1lCU3BnYWtNaGxiNktBMXAvQ3g0WkJ4WFJDXCIsXCJlbmFibGVkXCI6dHJ1ZSxcImFjY291bnROb25FeHBpcmVkXCI6dHJ1ZSxcImFjY291bnROb25Mb2NrZWRcIjp0cnVlLFwiY3JlZGVudGlhbHNOb25FeHBpcmVkXCI6dHJ1ZSxcImF1dGhvcml0aWVzXCI6W119IiwiY3JlYXRlZCI6MTUwNDg3MTM2ODMxOCwiZXhwIjoxNTA0ODgxMzY4fQ.0LJMDqH_v3zNeqQCBlVfrOQyJhpKZ6JK_HjLQfnrGeKTzkybBaJwa7YYfAIHMlLM5DdIF0KzatmpyPLrvrenxA"}
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
         * user : {"id":19,"userName":"test123456","name":"","sex":false,"image":"","email":"","phone":"","glob":0,"anonymous":false,"level":3,"address":"","createTime":"","birthday":"","deleteFlag":false}
         * token : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJ1c2VySWRcIjoxOSxcInVzZXJuYW1lXCI6XCJ0ZXN0MTIzNDU2XCIsXCJwYXNzd29yZFwiOlwiJDJhJDEwJGZYS2RVS1lCeE80R2RSak5hN1hodk9NV1d2N1lCU3BnYWtNaGxiNktBMXAvQ3g0WkJ4WFJDXCIsXCJlbmFibGVkXCI6dHJ1ZSxcImFjY291bnROb25FeHBpcmVkXCI6dHJ1ZSxcImFjY291bnROb25Mb2NrZWRcIjp0cnVlLFwiY3JlZGVudGlhbHNOb25FeHBpcmVkXCI6dHJ1ZSxcImF1dGhvcml0aWVzXCI6W119IiwiY3JlYXRlZCI6MTUwNDg3MTM2ODMxOCwiZXhwIjoxNTA0ODgxMzY4fQ.0LJMDqH_v3zNeqQCBlVfrOQyJhpKZ6JK_HjLQfnrGeKTzkybBaJwa7YYfAIHMlLM5DdIF0KzatmpyPLrvrenxA
         */

        private UserBean user;
        private String token;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserBean {
            /**
             * id : 19
             * userName : test123456
             * name :
             * sex : false
             * image :
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

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
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

            public void setLevel(Integer level) {
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
}
