package com.yuan7.tomcat.simple.impl;


import com.yuan7.tomcat.simple.BaseBean;
import com.yuan7.tomcat.simple.ResultBean;

import java.util.List;

/**
 * Created by Ly on 2017/4/29.
 * 新闻内容
 */

public class NewsBean extends BaseBean {

    /**
     * result : [{"addTime":"2017-04-30 08:21","source":"","title":"最新内容","type":"1","clickTimes":0,"imgUrl":"catServer/","contentUrl":"catServer/content.action?id=11","vedioUrl":"","dlUrl":"catServer/download.action?id=11","size":null,"downloadTimes":0,"id":11,"desc":""}]
     * pageCount : 1
     * pageNo : 1
     * pageSize : 5
     */

    private int pageCount;
    private String pageNo;
    private String pageSize;
    /**
     * addTime : 2017-04-30 08:21
     * source :
     * title : 最新内容
     * type : 1
     * clickTimes : 0
     * imgUrl : catServer/
     * contentUrl : catServer/content.action?id=11
     * vedioUrl :
     * dlUrl : catServer/download.action?id=11
     * size : null
     * downloadTimes : 0
     * id : 11
     * desc :
     */

    private List<ResultBean> result;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
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
}
