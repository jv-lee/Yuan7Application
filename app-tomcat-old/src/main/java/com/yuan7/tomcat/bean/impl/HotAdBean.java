package com.yuan7.tomcat.bean.impl;


import com.yuan7.tomcat.bean.BaseBean;
import com.yuan7.tomcat.bean.ResultBean;

import java.util.List;

/**
 * Created by Ly on 2017/5/17.
 */

public class HotAdBean extends BaseBean {

    /**
     * result : [{"addTime":"2017-05-08 16:00","source":"豌豆荚","title":"汤姆猫的摩托艇","type":"3","otherUrl":"","clickTimes":0,"imgUrl":"catServer/upload/images/abb9e401-5197-42ab-851c-b07bbaa1659c.png","addType":null,"contentUrl":"catServer/content.action?id=96","vedioUrl":"catServer/upload/files/17f240e7-6ae2-45bb-a3a6-dca76db29870.apk","dlUrl":"catServer/download.action?id=96","size":28914451,"downloadTimes":0,"id":96,"desc":"跳上摩托艇，会说话的汤姆或会说话的安吉拉与你相伴，体验最令人心潮澎湃的水上运动 "}]
     * pageCount :
     * pageNo :
     * pageSize :
     */

    private String pageCount;
    private String pageNo;
    private String pageSize;

    private List<ResultBean> result;

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    /**
     * addTime : 2017-05-08 16:00
     * source : 豌豆荚
     * title : 汤姆猫的摩托艇
     * type : 3
     * otherUrl :
     * clickTimes : 0
     * imgUrl : catServer/upload/images/abb9e401-5197-42ab-851c-b07bbaa1659c.png
     * addType : null
     * contentUrl : catServer/content.action?id=96
     * vedioUrl : catServer/upload/files/17f240e7-6ae2-45bb-a3a6-dca76db29870.apk
     * dlUrl : catServer/download.action?id=96
     * size : 28914451
     * downloadTimes : 0
     * id : 96
     * desc : 跳上摩托艇，会说话的汤姆或会说话的安吉拉与你相伴，体验最令人心潮澎湃的水上运动
     */
}
