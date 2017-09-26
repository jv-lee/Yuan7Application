package com.yuan7.tomcat.ui.main.home.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.home.HomeContract;
import com.yuan7.tomcat.ui.main.home.HomeModel;
import com.yuan7.tomcat.ui.main.home.HomePresenter;


import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/5/17.
 */
@Module
public class HomeModule {

    private HomeContract.View view;

    public HomeModule(HomeContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    HomeContract.Model provideModel(HomeModel homeModel) {
        return homeModel;
    }

    @ActivityScope
    @Provides
    HomeContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    HomeContract.Presenter providePresenter(HomePresenter homePresenter) {
        return homePresenter;
    }

}
