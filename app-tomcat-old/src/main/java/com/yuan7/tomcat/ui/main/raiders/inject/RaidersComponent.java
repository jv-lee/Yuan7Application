package com.yuan7.tomcat.ui.main.raiders.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.raiders.RaidersFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/5/17.
 */
@ActivityScope
@Component(modules = RaidersModule.class, dependencies = AppComponent.class)
public interface RaidersComponent {

    void inject(RaidersFragment fragment);
}
