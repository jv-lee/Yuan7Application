package com.yuan7.tomcat.ui.main.home;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.BannerBean;
import com.yuan7.tomcat.bean.impl.NewsBean;
import com.yuan7.tomcat.bean.impl.ProPagateBean;
import com.yuan7.tomcat.service.ApiService;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/5/17.
 */
@ActivityScope
public class HomeModel extends BaseModel implements HomeContract.Model {

    @Inject
    ApiService service;

    @Inject
    public HomeModel() {
    }

    @Override
    public Observable<BannerBean> doGetBanner() {
        return service.doGetBanner();
    }

    @Override
    public Observable<ProPagateBean> doGetProPatate() {
        return service.doGetProPatate();
    }

    @Override
    public Observable<NewsBean> doGetNews(int pageNo) {
        return service.doGetNews(pageNo);
    }
}
