package com.yuan7.tomcat.ui.login.inject;



import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.login.fragment.LoginFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/7.
 */
@ActivityScope
@Component(modules = LoginModule.class,dependencies = AppComponent.class)
public interface LoginComponent {
    void inject(LoginFragment fragment);
}
