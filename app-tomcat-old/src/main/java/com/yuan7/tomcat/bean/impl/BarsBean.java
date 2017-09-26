package com.yuan7.tomcat.bean.impl;


import com.yuan7.tomcat.bean.BaseBean;

/**
 * Created by Ly on 2017/4/25.
 */

public class BarsBean extends BaseBean {
    private int barId;
    private boolean isSelected;

    public BarsBean(int barId, boolean isSelected) {
        this.barId = barId;
        this.isSelected = isSelected;
    }

    public int getBarId() {
        return barId;
    }

    public void setBarId(int barId) {
        this.barId = barId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return "BarsBean{" +
                "barId=" + barId +
                ", isSelected=" + isSelected +
                '}';
    }
}
