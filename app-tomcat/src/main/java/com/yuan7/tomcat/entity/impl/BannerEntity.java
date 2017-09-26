package com.yuan7.tomcat.entity.impl;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */

public class BannerEntity<T> {

    /**
     * code : 2000
     * message : 加载banner成功
     * obj : [{"id":715,"title":"早间新闻","briefIntroduction":"这是一个早间新闻","author":"张三","source":"web","sourceUrl":"www.baidu.com","sourceType":0,"urlType":false,"viewTimes":0,"gootRate":0,"poorRate":0,"commentRate":0,"images":[{"id":153,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}],"state":"0","editeTime":"","size":1,"creatTime":1504685429000},{"id":714,"title":"早间新闻","briefIntroduction":"这是一个早间新闻","author":"张三","source":"web","sourceUrl":"www.baidu.com","sourceType":0,"urlType":false,"viewTimes":0,"gootRate":0,"poorRate":0,"commentRate":0,"images":[{"id":152,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}],"state":"0","editeTime":"","size":1,"creatTime":1504685420000},{"id":713,"title":"早间新闻","briefIntroduction":"这是一个早间新闻","author":"张三","source":"web","sourceUrl":"www.baidu.com","sourceType":0,"urlType":false,"viewTimes":0,"gootRate":0,"poorRate":0,"commentRate":0,"images":[{"id":151,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}],"state":"0","editeTime":"","size":1,"creatTime":1504685405000},{"id":712,"title":"早间新闻","briefIntroduction":"这是一个早间新闻","author":"张三","source":"web","sourceUrl":"www.baidu.com","sourceType":0,"urlType":false,"viewTimes":0,"gootRate":0,"poorRate":0,"commentRate":0,"images":[{"id":150,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}],"state":"0","editeTime":"","size":1,"creatTime":1504685393000},{"id":711,"title":"早间新闻","briefIntroduction":"这是一个早间新闻","author":"张三","source":"web","sourceUrl":"www.baidu.com","sourceType":0,"urlType":false,"viewTimes":0,"gootRate":0,"poorRate":0,"commentRate":0,"images":[{"id":149,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}],"state":"0","editeTime":"","size":1,"creatTime":1504685383000},{"id":710,"title":"早间新闻","briefIntroduction":"这是一个早间新闻","author":"张三","source":"web","sourceUrl":"www.baidu.com","sourceType":0,"urlType":false,"viewTimes":0,"gootRate":0,"poorRate":0,"commentRate":0,"images":[{"id":148,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}],"state":"0","editeTime":"","size":1,"creatTime":1504685373000},{"id":709,"title":"早间新闻","briefIntroduction":"这是一个早间新闻","author":"张三","source":"web","sourceUrl":"www.baidu.com","sourceType":0,"urlType":false,"viewTimes":0,"gootRate":0,"poorRate":0,"commentRate":0,"images":[{"id":147,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}],"state":"0","editeTime":"","size":1,"creatTime":1504685370000},{"id":708,"title":"早间新闻","briefIntroduction":"这是一个早间新闻","author":"张三","source":"web","sourceUrl":"www.baidu.com","sourceType":0,"urlType":false,"viewTimes":0,"gootRate":0,"poorRate":0,"commentRate":0,"images":[{"id":146,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}],"state":"0","editeTime":"","size":1,"creatTime":1504685279000},{"id":707,"title":"早间新闻","briefIntroduction":"这是一个早间新闻","author":"张三","source":"web","sourceUrl":"www.baidu.com","sourceType":0,"urlType":false,"viewTimes":0,"gootRate":0,"poorRate":0,"commentRate":0,"images":[{"id":145,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}],"state":"0","editeTime":"","size":1,"creatTime":1504685269000},{"id":706,"title":"早间新闻","briefIntroduction":"这是一个早间新闻","author":"张三","source":"web","sourceUrl":"www.baidu.com","sourceType":0,"urlType":false,"viewTimes":0,"gootRate":0,"poorRate":0,"commentRate":0,"images":[{"id":144,"url":"http://img.aiimg.com/uploads/userup/0912/0309232S193.jpg","type":0,"size":10,"newsId":""}],"state":"0","editeTime":"","size":1,"creatTime":1504685259000}]
     */
    private Integer code;
    private String message;
    private List<T> obj;

    public List<T> getObj() {
        return obj;
    }

    public void setObj(List<T> obj) {
        this.obj = obj;
    }

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

}
