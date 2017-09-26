package com.yuan7.tomcat.ui.menu.code;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultBeanEntity;
import com.yuan7.tomcat.entity.impl.UserEntity;
import com.yuan7.tomcat.server.ApiServer;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/9/22.
 */
@ActivityScope
public class CodeModel extends BaseModel implements CodeContract.Model {

    @Inject
    ApiServer apiServer;

    @Inject
    public CodeModel() {
    }

    @Override
    public Observable<ResultBeanEntity> doPostCodeSend(String code) {
        return apiServer.doPostInvite(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ResultBeanEntity<List<UserEntity>>> doPostCodeList() {
        return apiServer.doPostGetMyInvite()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
