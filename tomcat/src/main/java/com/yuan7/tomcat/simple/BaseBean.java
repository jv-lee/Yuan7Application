package com.yuan7.tomcat.simple;

import java.io.Serializable;

/**
 * Created by Ly on 2017/4/22
 */

public class BaseBean implements Serializable {

    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
