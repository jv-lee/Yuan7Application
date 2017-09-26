package com.yuan7.tomcat.ui.content.app.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.content.app.AppDataActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/5/25.
 */
@ActivityScope
@Component(modules = AppDataModule.class, dependencies = AppComponent.class)
public interface AppDataComponent {
    void inject(AppDataActivity activity);
}
