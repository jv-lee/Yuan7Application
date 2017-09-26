package com.yuan7.tomcat.ui.main.home.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.home.HomeFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/5/17.
 */
@ActivityScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {

    void inject(HomeFragment fragment);
}
