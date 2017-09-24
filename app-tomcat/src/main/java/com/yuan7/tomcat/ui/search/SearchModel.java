package com.yuan7.tomcat.ui.search;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.SearchEntity;
import com.yuan7.tomcat.server.ApiServer;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/9/21.
 */
@ActivityScope
public class SearchModel extends BaseModel implements SearchContract.Model {

    @Inject
    ApiServer apiServer;

    @Inject
    public SearchModel() {
    }

    @Override
    public Observable<ResultDataEntity<SearchEntity>> doPostSearch(String title, int pageNo) {
        return apiServer.doPostSearch(pageNo, AppConfig.PAGE_NUMBER, title, AppConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
