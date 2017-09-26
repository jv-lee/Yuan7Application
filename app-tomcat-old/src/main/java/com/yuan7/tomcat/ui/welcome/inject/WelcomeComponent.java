package com.yuan7.tomcat.ui.welcome.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.welcome.WelcomeActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/5/27.
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface WelcomeComponent {
    void inject(WelcomeActivity activity);
}
