package com.yuan7.tomcat.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class ResultBeansEntity<T> {
    private int code;
    private String message;
    private List<T> obj;

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

    public List<T> getObj() {
        return obj;
    }

    public void setObj(List<T> obj) {
        this.obj = obj;
    }
}
