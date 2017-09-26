package com.yuan7.tomcat.ui.main.video.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.video.VideoFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/5/18.
 */
@ActivityScope
@Component(modules = VideoModule.class, dependencies = AppComponent.class)
public interface VideoComponent {

    void inject(VideoFragment fragment);
}
