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
 * Created by Administrator on 2017/9/7.
 */
@ActivityScope
public class LoginModel extends BaseModel implements LoginContract.Model {

    @Inject
    public ApiServer apiServer;

    @Inject
    public LoginModel() {
    }

    @Override
    public Observable<Response<UserEntity>> doPostLogin(int type, String username, String password) {
        return apiServer.doPostLogin(type, username, password, ParameterUtil.getSimpleIMEI(mApplication), true);
    }

    @Override
    public Observable<Response<UserEntity>> doPostFlyLogin() {
        return apiServer.doPostFlyLogin(ParameterUtil.getSimpleIMEI(mApplication), AppConfig.APP_ID);
    }
}
