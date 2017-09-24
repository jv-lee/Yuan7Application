package com.yuan7.tomcat.ui.menu.shop.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.shop.ShopFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/25.
 */
@ActivityScope
@Component(modules = ShopModule.class,dependencies = AppComponent.class)
public interface ShopComponent {
    void inject(ShopFragment fragment);
}
