package com.yuan7.tomcat.ui.main.info.news.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.info.news.NewsContentFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/15.
 */
@ActivityScope
@Component(modules = NewsModule.class, dependencies = AppComponent.class)
public interface NewsComponent {

    void inject(NewsContentFragment fragment);
}
