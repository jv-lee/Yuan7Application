package com.yuan7.tomcat.ui.product.inject;

import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.product.fragment.ProductFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/19.
 */
@ActivityScope
@Component(modules = ProductModule.class, dependencies = AppComponent.class)
public interface ProductComponent {
    void inject(ProductFragment fragment);
}
