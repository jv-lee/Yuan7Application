package com.yuan7.tomcat.ui.main.commu.community.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.commu.community.CommunityContentFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/21.
 */
@ActivityScope
@Component(modules = CommunityModule.class, dependencies = AppComponent.class)
public interface CommunityComponent {
    void inject(CommunityContentFragment fragment);
}
