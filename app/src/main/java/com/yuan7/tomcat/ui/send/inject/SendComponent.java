package com.yuan7.tomcat.ui.send.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.send.SendActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/12.
 */
@ActivityScope
@Component(modules = SendModule.class, dependencies = AppComponent.class)
public interface SendComponent {
    void inject(SendActivity activity);
}
