package com.yuan7.tomcat.ui.main.info.hot.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.info.hot.HotContract;
import com.yuan7.tomcat.ui.main.info.hot.HotModel;
import com.yuan7.tomcat.ui.main.info.hot.HotPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/15.
 */
@Module
public class HotModule {

    private HotContract.View view;

    public HotModule(HotContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    HotContract.Model provideModel(HotModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    HotContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    HotContract.Presenter providePresenter(HotPresenter presenter) {
        return presenter;
    }

}
