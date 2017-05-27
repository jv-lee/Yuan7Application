package com.yuan7.tomcat.ui.main.recommend;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.RecommendBean;
import com.yuan7.tomcat.service.ApiService;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/5/18.
 */
@ActivityScope
public class RecommendModel extends BaseModel implements RecommendContract.Model {

    @Inject
    ApiService service;

    @Inject
    public RecommendModel() {

    }

    @Override
    public Observable<RecommendBean> doGetRecommend(int pageNo) {
        return service.doGetRecommend(pageNo);
    }
}
