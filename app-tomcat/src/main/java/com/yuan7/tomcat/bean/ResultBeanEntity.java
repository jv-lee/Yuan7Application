package com.yuan7.tomcat.bean;

/**
 * Created by Administrator on 2017/9/21.
 */

public class ResultBeanEntity<T> {
    private int code;
    private String message;
    private T obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
