package com.yuan7.tomcat.entity.impl;

/**
 * Created by Administrator on 2017/10/11.
 */

public class ActiviEntity {



    private int thisDay; //当天为 第几天
    private int thisStatus; //当天状态 1 2 3   1为未签到  2 为已签到  3为可签到
    private boolean hasDay;

    public ActiviEntity(int thisDay, int thisStatus, boolean hasDay) {
        this.thisDay = thisDay;
        this.thisStatus = thisStatus;
        this.hasDay = hasDay;
    }

    public int getThisDay() {
        return thisDay;
    }

    public void setThisDay(int thisDay) {
        this.thisDay = thisDay;
    }

    public int getThisStatus() {
        return thisStatus;
    }

    public void setThisStatus(int thisStatus) {
        this.thisStatus = thisStatus;
    }

    public boolean isHasDay() {
        return hasDay;
    }

    public void setHasDay(boolean hasDay) {
        this.hasDay = hasDay;
    }
}
