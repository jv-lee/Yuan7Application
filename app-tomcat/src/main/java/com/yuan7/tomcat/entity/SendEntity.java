package com.yuan7.tomcat.entity;

/**
 * Created by Administrator on 2017/8/29.
 */

public class SendEntity {
    private int id;
    private String title;
    private String content;
    private String day;
    private String month;
    private int readCount;
    private int inputCount;
    private int niceCount;

    public SendEntity(int id, String title, String content, String day, String month, int readCount, int inputCount, int niceCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.day = day;
        this.month = month;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
