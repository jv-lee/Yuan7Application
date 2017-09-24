package com.yuan7.tomcat.ui.main.start.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.start.StartFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/15.
 */
@ActivityScope
@Component(modules = StartModule.class, dependencies = AppComponent.class)
public interface StartComponent {
    void inject(StartFragment fragment);
}
