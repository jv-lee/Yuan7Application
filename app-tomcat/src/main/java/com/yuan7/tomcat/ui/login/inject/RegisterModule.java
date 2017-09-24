package com.yuan7.tomcat.ui.login.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.login.RegisterContract;
import com.yuan7.tomcat.ui.login.RegisterModel;
import com.yuan7.tomcat.ui.login.RegisterPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/8.
 */
@Module
public class RegisterModule {

    private RegisterContract.View view;

    public RegisterModule(RegisterContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    RegisterContract.Model provideModel(RegisterModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    RegisterContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    RegisterContract.Presenter providePresenter(RegisterPresenter presenter) {
        return presenter;
    }
}
