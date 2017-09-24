package com.yuan7.tomcat.ui.product.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.product.ProductContract;
import com.yuan7.tomcat.ui.product.ProductModel;
import com.yuan7.tomcat.ui.product.ProductPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/19.
 */
@Module
public class ProductModule {
    private ProductContract.View view;

    public ProductModule(ProductContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ProductContract.Model provideModel(ProductModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    ProductContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ProductContract.Presenter providePresenter(ProductPresenter presenter) {
        return presenter;
    }
}
