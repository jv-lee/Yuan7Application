package com.yuan7.tomcat.ui.main.info.video.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.info.video.VideoContentFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/15.
 */
@ActivityScope
@Component(modules = VideoModule.class, dependencies = AppComponent.class)
public interface VideoComponent {
    void inject(VideoContentFragment fragment);
}
