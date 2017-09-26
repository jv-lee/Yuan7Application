package com.yuan7.tomcat.entity.impl;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */

public class FileResponseEntity {
    private Integer code;
    private String message;
    String obj;

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

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}
