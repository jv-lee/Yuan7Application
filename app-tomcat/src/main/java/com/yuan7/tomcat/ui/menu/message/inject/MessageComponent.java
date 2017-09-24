package com.yuan7.tomcat.ui.menu.message.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.message.MessageContentFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/25.
 */
@ActivityScope
@Component(modules = MessageModule.class,dependencies = AppComponent.class)
public interface MessageComponent {
    void inject(MessageContentFragment fragment);
}
