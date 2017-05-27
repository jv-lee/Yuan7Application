package com.yuan7.tomcat.ui.main.recommend.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.recommend.RecommendFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/5/18.
 */
@ActivityScope
@Component(modules = RecommendModule.class, dependencies = AppComponent.class)
public interface RecommendComponent {

    void inject(RecommendFragment fragment);

}
