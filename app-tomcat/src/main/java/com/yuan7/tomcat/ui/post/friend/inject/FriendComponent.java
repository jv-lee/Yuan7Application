package com.yuan7.tomcat.ui.post.friend.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.post.friend.FriendActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/21.
 */
@ActivityScope
@Component(modules = FriendModule.class, dependencies = AppComponent.class)
public interface FriendComponent {
    void inject(FriendActivity activity);
}
