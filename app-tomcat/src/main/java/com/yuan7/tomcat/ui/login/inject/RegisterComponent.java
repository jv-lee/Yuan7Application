package com.yuan7.tomcat.ui.login.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.login.fragment.RegisterFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/8.
 */
@ActivityScope
@Component(modules = RegisterModule.class, dependencies = AppComponent.class)
public interface RegisterComponent {
    void inject(RegisterFragment fragment);
}
