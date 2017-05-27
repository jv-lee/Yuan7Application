package com.yuan7.tomcat.simple.impl;


import com.yuan7.tomcat.simple.BaseBean;
import com.yuan7.tomcat.simple.ResultBean;

import java.util.List;

/**
 * Created by Ly on 2017/4/29.
 * 获取视频
 */

public class RaidersBean extends BaseBean {


    /**
     * result : [{"addTime":"2017-04-30 08:24","source":"未知","title":"会说话的汤姆猫","type":"3","clickTimes":0,"imgUrl":"catServer//upload/images/bdfa6f56-5b9e-43e4-975a-ec71e8a62c65.jpg","contentUrl":"catServer/content.action?id=14","vedioUrl":"","dlUrl":"catServer/download.action?id=14","size":null,"downloadTimes":0,"id":14,"desc":"超可爱的宠物养成游戏"}]
     * pageCount : 1
     * pageNo : 1
     * pageSize : 10
     */

    private int pageCount;
    private String pageNo;
    private String pageSize;
    /**
     * addTime : 2017-04-30 08:24
     * source : 未知
     * title : 会说话的汤姆猫
     * type : 3
     * clickTimes : 0
     * imgUrl : catServer//upload/images/bdfa6f56-5b9e-43e4-975a-ec71e8a62c65.jpg
     * contentUrl : catServer/content.action?id=14
     * vedioUrl :
     * dlUrl : catServer/download.action?id=14
     * size : null
     * downloadTimes : 0
     * id : 14
     * desc : 超可爱的宠物养成游戏
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
