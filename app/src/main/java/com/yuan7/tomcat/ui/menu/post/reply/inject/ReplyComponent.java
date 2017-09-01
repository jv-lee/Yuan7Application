package com.yuan7.tomcat.ui.menu.post.reply.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.post.reply.ReplyFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/29.
 */
@ActivityScope
@Component(modules = ReplyModule.class,dependencies = AppComponent.class)
public interface ReplyComponent {
    void inject(ReplyFragment fragment);
}
