package com.yuan7.tomcat.ui.main.commu.community.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.commu.community.CommunityContract;
import com.yuan7.tomcat.ui.main.commu.community.CommunityModel;
import com.yuan7.tomcat.ui.main.commu.community.CommunityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/21.
 */
@Module
public class CommunityModule {

    private CommunityContract.View view;

    public CommunityModule(CommunityContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    CommunityContract.Model provideModel(CommunityModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    CommunityContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    CommunityContract.Presenter providePresenter(CommunityPresenter presenter) {
        return presenter;
    }

}
