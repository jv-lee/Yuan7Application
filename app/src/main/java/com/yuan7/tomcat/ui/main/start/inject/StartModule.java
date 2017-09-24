package com.yuan7.tomcat.ui.main.start.inject;


import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.start.StartContract;
import com.yuan7.tomcat.ui.main.start.StartModel;
import com.yuan7.tomcat.ui.main.start.StartPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/15.
 */
@Module
public class StartModule {
    private StartContract.View view;

    public StartModule(StartContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    StartContract.Model provideModel(StartModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    StartContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    StartContract.Presenter providePresenter(StartPresenter presenter) {
        return presenter;
    }
}
