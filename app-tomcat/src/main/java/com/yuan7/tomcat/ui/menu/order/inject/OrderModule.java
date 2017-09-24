package com.yuan7.tomcat.ui.menu.order.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.order.OrderContract;
import com.yuan7.tomcat.ui.menu.order.OrderModel;
import com.yuan7.tomcat.ui.menu.order.OrderPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/21.
 */
@Module
public class OrderModule {
    private OrderContract.View view;

    public OrderModule(OrderContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    OrderContract.Model provideModel(OrderModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    OrderContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    OrderContract.Presenter providePresenter(OrderPresenter presenter) {
        return presenter;
    }
}
