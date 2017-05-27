package com.yuan7.tomcat.ui.content.app;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.DetailBean;
import com.yuan7.tomcat.bean.impl.HotAdBean;
import com.yuan7.tomcat.service.ApiService;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/5/25.
 */
@ActivityScope
public class AppDataModel extends BaseModel implements AppDataContract.Model {

    @Inject
    ApiService service;

    @Inject
    public AppDataModel() {
    }

    @Override
    public Observable<DetailBean> doGetDetail(String id) {
        return service.doGetDetail(id);
    }

    @Override
    public Observable<HotAdBean> doGetHot() {
        return service.doGetHot();
    }
}
