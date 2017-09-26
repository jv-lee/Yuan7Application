package com.yuan7.tomcat.ui.main.raiders.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.raiders.RaidersContract;
import com.yuan7.tomcat.ui.main.raiders.RaidersModel;
import com.yuan7.tomcat.ui.main.raiders.RaidersPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/5/17.
 */
@Module
public class RaidersModule {

    private RaidersContract.View view;

    public RaidersModule(RaidersContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    RaidersContract.Model provideModel(RaidersModel raidersModel) {
        return raidersModel;
    }

    @ActivityScope
    @Provides
    RaidersContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    RaidersContract.Presenter providePresenter(RaidersPresenter raidersPresenter) {
        return raidersPresenter;
    }
}
