package com.yuan7.tomcat.ui.login.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.login.LoginContract;
import com.yuan7.tomcat.ui.login.LoginModel;
import com.yuan7.tomcat.ui.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/7.
 */
@Module
public class LoginModule {

    private LoginContract.View view;

    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    LoginContract.Model provideModel(LoginModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    LoginContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    LoginContract.Presenter providePresenter(LoginPresenter presenter) {
        return presenter;
    }
    
}
