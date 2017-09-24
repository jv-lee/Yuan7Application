package com.yuan7.tomcat.ui.menu.code.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.code.CodeFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/22.
 */
@ActivityScope
@Component(modules = CodeModule.class, dependencies = AppComponent.class)
public interface CodeComponent {
    void inject(CodeFragment fragment);
}
