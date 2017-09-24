package com.yuan7.tomcat.entity;

/**
 * Created by Administrator on 2017/8/29.
 */

public class ReplyEntity {
    private int id;
    private String title;
    private String content;
    private String dateStr;
    private int readCount;
    private int inputCount;
    private int niceCount;

    public ReplyEntity(int id, String title, String content, String dateStr, int readCount, int inputCount, int niceCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateStr = dateStr;
        this.readCount = readCount;
        this.inputCount = inputCount;
        this.niceCount = niceCount;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getInputCount() {
        return inputCount;
    }

    public void setInputCount(int inputCount) {
        this.inputCount = inputCount;
    }

    public int getNiceCount() {
        return niceCount;
    }

    public void setNiceCount(int niceCount) {
        this.niceCount = niceCount;
    }
}
