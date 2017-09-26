package com.yuan7.tomcat.ui.main.comm.aq;

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
public class AQModel extends BaseModel implements AQContract.Model {

    @Inject
    public ApiServer apiServer;

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";
    private String content = "this is community friend message , this is community friend message, this is community friend message";


    @Inject
    public AQModel() {
    }

    @Override
    public Observable<ResultDataEntity<ContentEntity>> doPostAQEntity(int pageNo, int type) {
        return apiServer.doPostAQList(pageNo, AppConfig.PAGE_NUMBER, type, AppConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<ContentEntity>> doLocalEntity(final int pageNo) {
        return null;
    }
}
