package com.yuan7.tomcat.bean.impl;


import com.yuan7.tomcat.bean.BaseBean;
import com.yuan7.tomcat.bean.ResultBean;

import java.util.List;

/**
 * Created by Ly on 2017/4/29.
 * 宣传图
 */

public class ProPagateBean extends BaseBean {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    /**
     * id : 1
     * title : test
     * imgUrl : server/test.jpg
     * type : 1
     * contentUrl : server/content.action?id=1
     * dlUrl : server/download.action?id=1
     * status : 200
     */
}
