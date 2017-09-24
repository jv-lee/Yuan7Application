package com.yuan7.tomcat.rx.entity;

/**
 * Created by Administrator on 2017/9/18.
 */

public class AddressEntity {
    private String linkman;
    private String phoneNumber;
    private String getTime;
    private String province;
    private String city;
    private String county;
    private String street;
    private String addressDes;
    private boolean addressFlag;

    public AddressEntity(String linkman, String phoneNumber, String getTime, String province, String city, String county, String street, String addressDes, boolean addressFlag) {
        this.linkman = linkman;
        this.phoneNumber = phoneNumber;
        this.getTime = getTime;
        this.province = province;
        this.city = city;
        this.county = county;
        this.street = street;
        this.addressDes = addressDes;
        this.addressFlag = addressFlag;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressDes() {
        return addressDes;
    }

    public void setAddressDes(String addressDes) {
        this.addressDes = addressDes;
    }

    public boolean isAddressFlag() {
        return addressFlag;
    }

    public void setAddressFlag(boolean addressFlag) {
        this.addressFlag = addressFlag;
    }
}
