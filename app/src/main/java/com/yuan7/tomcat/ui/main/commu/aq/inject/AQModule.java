package com.yuan7.tomcat.ui.main.commu.aq.inject;


import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.commu.aq.AQContract;
import com.yuan7.tomcat.ui.main.commu.aq.AQModel;
import com.yuan7.tomcat.ui.main.commu.aq.AQPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/21.
 */
@Module
public class AQModule {
    private AQContract.View view;

    public AQModule(AQContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    AQContract.Model provideModel(AQModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    AQContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    AQContract.Presenter providePresenter(AQPresenter presenter) {
        return presenter;
    }
}
