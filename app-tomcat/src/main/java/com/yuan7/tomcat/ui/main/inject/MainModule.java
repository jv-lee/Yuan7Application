package com.yuan7.tomcat.ui.main.inject;


import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.MainContract;
import com.yuan7.tomcat.ui.main.MainModel;
import com.yuan7.tomcat.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/22.
 */
@Module
public class MainModule {
    private MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainContract.Model provideModel(MainModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    MainContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainContract.Presenter providePresenter(MainPresenter presenter) {
        return presenter;
    }
}
