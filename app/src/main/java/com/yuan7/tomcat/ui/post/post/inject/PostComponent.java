package com.yuan7.tomcat.ui.post.post.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.post.post.PostFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/29.
 */
@ActivityScope
@Component(modules = PostModule.class,dependencies = AppComponent.class)
public interface PostComponent {
    void inject(PostFragment fragment);
}
