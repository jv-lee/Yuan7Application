package com.yuan7.tomcat.ui.main.comm.friend.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.comm.friend.FriendContentFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/21.
 */
@ActivityScope
@Component(modules = FriendModule.class, dependencies = AppComponent.class)
public interface FriendComponent {

    void inject(FriendContentFragment fragment);
}
