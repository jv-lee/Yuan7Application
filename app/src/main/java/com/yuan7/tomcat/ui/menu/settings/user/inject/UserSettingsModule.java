package com.yuan7.tomcat.ui.menu.settings.user.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.settings.user.UserSettingsContract;
import com.yuan7.tomcat.ui.menu.settings.user.UserSettingsModel;
import com.yuan7.tomcat.ui.menu.settings.user.UserSettingsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/12.
 */
@ActivityScope
@Module
public class UserSettingsModule {

    private UserSettingsContract.View view;

    public UserSettingsModule(UserSettingsContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    UserSettingsContract.Model provideModel(UserSettingsModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    UserSettingsContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    UserSettingsContract.Presenter providePresenter(UserSettingsPresenter presenter) {
        return presenter;
    }
}
