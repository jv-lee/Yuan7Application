package com.yuan7.tomcat.ui.menu.settings.user.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.settings.user.UserSettingsFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/12.
 */
@ActivityScope
@Component(modules = UserSettingsModule.class, dependencies = AppComponent.class)
public interface UserSettingsComponent {
    void inject(UserSettingsFragment fragment);
}
