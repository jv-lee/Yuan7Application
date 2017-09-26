package com.yuan7.tomcat.ui.main.info.news;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.ContentEntity;
import com.yuan7.tomcat.server.ApiServer;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/15.
 */
@ActivityScope
public class NewsModel extends BaseModel implements NewsContract.Model {

    @Inject
    ApiServer apiServer;
    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";

    @Inject
    public NewsModel() {
    }

    @Override
    public Observable<ResultDataEntity<ContentEntity>> doPostNews(int pageNo, int type) {
        return apiServer.doPostNewsList(pageNo, AppConfig.PAGE_NUMBER, type, AppConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List> doLocalNews(final int pageNo) {
        return null;
    }
}
