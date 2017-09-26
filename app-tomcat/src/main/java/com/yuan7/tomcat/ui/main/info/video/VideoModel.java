package com.yuan7.tomcat.ui.main.info.video;

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
public class VideoModel extends BaseModel implements VideoContract.Model {

    @Inject
    ApiServer apiServer;

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";

    @Inject
    public VideoModel() {
    }

    @Override
    public Observable<ResultDataEntity<ContentEntity>> doPostVideo(int pageNo, int type) {
        return apiServer.doPostVideoList(pageNo, AppConfig.PAGE_NUMBER, type, AppConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List> doLocalVideo(final int pageNo) {
        return null;
    }
}
