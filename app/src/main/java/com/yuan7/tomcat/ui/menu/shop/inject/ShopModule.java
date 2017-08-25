package com.yuan7.tomcat.ui.menu.shop.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.shop.ShopContract;
import com.yuan7.tomcat.ui.menu.shop.ShopModel;
import com.yuan7.tomcat.ui.menu.shop.ShopPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/25.
 */
@Module
public class ShopModule {
    private ShopContract.View view;

    public ShopModule(ShopContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ShopContract.Model provideModel(ShopModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    ShopContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ShopContract.Presenter providePresenter(ShopPresenter presenter) {
        return presenter;
    }
}
