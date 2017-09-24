package com.yuan7.tomcat.bean;

/**
 * Created by Administrator on 2017/9/7.
 */

public class ResultEntity<T> {
    private int code;
    private String message;
    private ObjEntity<T> obj;

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

    public ObjEntity getObj() {
        return obj;
    }

    public void setObj(ObjEntity obj) {
        this.obj = obj;
    }
}
