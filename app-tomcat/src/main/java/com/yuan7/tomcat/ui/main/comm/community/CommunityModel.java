package com.yuan7.tomcat.ui.main.comm.community;

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
 * Created by Administrator on 2017/8/21.
 */
@ActivityScope
public class CommunityModel extends BaseModel implements CommunityContract.Model {

    @Inject
    ApiServer apiServer;

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";
    private String content = "this is community friend message , this is community friend message, this is community friend message";

    @Inject
    public CommunityModel() {
    }

    @Override
    public Observable<ResultDataEntity<ContentEntity>> doPostCommunity(int pageNo, int type) {
        return apiServer.doPostCommunityList(pageNo, AppConfig.PAGE_NUMBER, type, AppConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List> doLocalCommunity(final int pageNo) {
        return null;
    }
}
