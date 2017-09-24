package com.yuan7.tomcat.bean.impl;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */

public class FileResponseEntity {
    private Integer code;
    private String message;
    List<FileData> obj;

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

    public List<FileData> getObj() {
        return obj;
    }

    public void setObj(List<FileData> obj) {
        this.obj = obj;
    }

    public class FileData {
        private String statusMsg;
        private String url;
        private String fileName;
        private String newFilename;

        public String getStatusMsg() {
            return statusMsg;
        }

        public void setStatusMsg(String statusMsg) {
            this.statusMsg = statusMsg;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getNewFilename() {
            return newFilename;
        }

        public void setNewFilename(String newFilename) {
            this.newFilename = newFilename;
        }
    }
}
