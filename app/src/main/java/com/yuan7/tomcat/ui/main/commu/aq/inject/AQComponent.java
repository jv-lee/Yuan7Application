package com.yuan7.tomcat.ui.main.commu.aq.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.commu.aq.AQContentFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/21.
 */
@ActivityScope
@Component(modules = AQModule.class, dependencies = AppComponent.class)
public interface AQComponent {
    void inject(AQContentFragment fragment);
}
