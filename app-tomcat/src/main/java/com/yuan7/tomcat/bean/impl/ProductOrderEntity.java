package com.yuan7.tomcat.bean.impl;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class ProductOrderEntity {

    /**
     * id : 46
     * usersId : 19
     * money : 100.0
     * state : 0
     * createTime : 2017-09-19 11:32:31
     * address : 张三	18682145711
     * 新疆	巴音郭楞州	且末县	且末镇
     * 河边
     * name : 加速道具
     * editTime : null
     * operationId : null
     * remark : null
     * deleteflag : 0
     * commodityDetail : [{"id":1018,"title":"加速道具","briefIntroduction":"速度提升","description":"可兑换","viewTimes":0,"gootRate":0,"poorRate":0,"commentRate":1,"photos":null,"price":100,"orderPrice":100,"stock":51,"state":"1","editeTime":"2017-09-20 17:50:58","creatTime":"2017-09-14 11:28:38","deleteflag":false,"userid":1,"classify":"hot","content":null,"count":1}]
     */

    private int id;
    private int usersId;
    private double money;
    private int state;
    private String createTime;
    private String address;
    private String name;
    private Object editTime;
    private Object operationId;
    private Object remark;
    private int deleteflag;
    private List<CommodityDetailBean> commodityDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getEditTime() {
        return editTime;
    }

    public void setEditTime(Object editTime) {
        this.editTime = editTime;
    }

    public Object getOperationId() {
        return operationId;
    }

    public void setOperationId(Object operationId) {
        this.operationId = operationId;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public int getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(int deleteflag) {
        this.deleteflag = deleteflag;
    }

    public List<CommodityDetailBean> getCommodityDetail() {
        return commodityDetail;
    }

    public void setCommodityDetail(List<CommodityDetailBean> commodityDetail) {
        this.commodityDetail = commodityDetail;
    }

    public static class CommodityDetailBean {
        /**
         * id : 1018
         * title : 加速道具
         * briefIntroduction : 速度提升
         * description : 可兑换
         * viewTimes : 0
         * gootRate : 0
         * poorRate : 0
         * commentRate : 1
         * photos : null
         * price : 100.0
         * orderPrice : 100.0
         * stock : 51
         * state : 1
         * editeTime : 2017-09-20 17:50:58
         * creatTime : 2017-09-14 11:28:38
         * deleteflag : false
         * userid : 1
         * classify : hot
         * content : null
         * count : 1
         */

        private int id;
        private String title;
        private String briefIntroduction;
        private String description;
        private int viewTimes;
        private int gootRate;
        private int poorRate;
        private int commentRate;
        private Object photos;
        private double price;
        private double orderPrice;
        private int stock;
        private String state;
        private String editeTime;
        private String creatTime;
        private boolean deleteflag;
        private int userid;
        private String classify;
        private Object content;
        private int count;

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

        public String getBriefIntroduction() {
            return briefIntroduction;
        }

        public void setBriefIntroduction(String briefIntroduction) {
            this.briefIntroduction = briefIntroduction;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        public Object getPhotos() {
            return photos;
        }

        public void setPhotos(Object photos) {
            this.photos = photos;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getOrderPrice() {
            return orderPrice;
        }

        public void setOrderPrice(double orderPrice) {
            this.orderPrice = orderPrice;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
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

        public String getCreatTime() {
            return creatTime;
        }

        public void setCreatTime(String creatTime) {
            this.creatTime = creatTime;
        }

        public boolean isDeleteflag() {
            return deleteflag;
        }

        public void setDeleteflag(boolean deleteflag) {
            this.deleteflag = deleteflag;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getClassify() {
            return classify;
        }

        public void setClassify(String classify) {
            this.classify = classify;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
