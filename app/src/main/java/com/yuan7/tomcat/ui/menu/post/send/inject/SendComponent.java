package com.yuan7.tomcat.ui.menu.post.send.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.post.send.SendFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/29.
 */
@ActivityScope
@Component(modules = SendModule.class,dependencies = AppComponent.class)
public interface SendComponent {
    void inject(SendFragment fragment);
}
