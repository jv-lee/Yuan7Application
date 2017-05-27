package com.yuan7.tomcat.ui.main.raiders;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.RaidersBean;
import com.yuan7.tomcat.service.ApiService;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/5/17.
 */
@ActivityScope
public class RaidersModel extends BaseModel implements RaidersContract.Model {

    @Inject
    ApiService service;

    @Inject
    public RaidersModel() {
    }

    @Override
    public Observable<RaidersBean> doGetRaiders(int pageNo) {
        return service.doGetRaiders(pageNo);
    }
}
