package com.yuan7.tomcat.entity;

/**
 * Created by Administrator on 2017/8/25.
 */

public class MessageEntity {
    private int id;
    private String userName;
    private String messageContent;
    private String dateStr;
    private String iconUrl;

    public MessageEntity(int id, String userName, String messageContent, String dateStr, String iconUrl) {
        this.id = id;
        this.userName = userName;
        this.messageContent = messageContent;
        this.dateStr = dateStr;
        this.iconUrl = iconUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
