package com.yuan7.tomcat.ui.login;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.UserEntity;
import com.yuan7.tomcat.server.ApiServer;
import com.yuan7.tomcat.utils.ParameterUtil;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/9/8.
 */
@ActivityScope
public class RegisterModel extends BaseModel implements RegisterContract.Model {

    @Inject
    ApiServer apiServer;

    @Inject
    public RegisterModel() {
    }

    @Override
    public Observable<Response<UserEntity>> doPostRegister(String username, String password) {
        return apiServer.doPostRegister(username, password, ParameterUtil.getSimpleIMEI(mApplication), AppConfig.APP_ID);
    }
}
