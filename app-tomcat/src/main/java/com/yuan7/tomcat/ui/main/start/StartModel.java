package com.yuan7.tomcat.ui.main.start;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.StartEntity;
import com.yuan7.tomcat.server.ApiServer;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/9/15.
 */
@ActivityScope
public class StartModel extends BaseModel implements StartContract.Model {

    @Inject
    ApiServer apiServer;

    @Inject
    public StartModel() {
    }

    @Override
    public Observable<StartEntity> doPostStart() {
        return apiServer.doPostStartApp(AppConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
