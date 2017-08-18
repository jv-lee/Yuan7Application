package com.yuan7.tomcat.ui.main.info.hot.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.info.hot.HotFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/15.
 */
@ActivityScope
@Component(modules = HotModule.class, dependencies = AppComponent.class)
public interface HotComponent {

    void inject(HotFragment fragment);
}
