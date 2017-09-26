package com.yuan7.tomcat.ui.main;

import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultBeanEntity;
import com.yuan7.tomcat.entity.impl.UserMessage;
import com.yuan7.tomcat.server.ApiServer;
import com.yuan7.tomcat.utils.SPUtil;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/9/22.
 */
@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {

    @Inject
    ApiServer apiServer;

    @Inject
    public MainModel() {
    }

    @Override
    public Observable<ResultBeanEntity<UserMessage>> doPostMenuData() {
        return apiServer.doPostUserMessage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ResultBeanEntity> doPostFirstLogin() {
        return apiServer.doPostFirstLogin((int) SPUtil.get(UserParams.USER_ID, 0))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
