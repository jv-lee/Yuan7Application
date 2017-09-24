package com.yuan7.tomcat.ui.menu.order.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.order.OrderFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/21.
 */
@ActivityScope
@Component(modules = OrderModule.class, dependencies = AppComponent.class)
public interface OrderComponent {
    void inject(OrderFragment fragment);
}
