package com.yuan7.tomcat.ui.menu.shop;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.ResultBeansEntity;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.ProductEntity;


import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/25.
 */

public interface ShopContract {
    interface View extends IView {
        void bindBannerData(ResultBeansEntity<ProductEntity> result);

        void bindShopData(int pageNo, ResultDataEntity<ProductEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindBannerData();

        void bindShopData(int pageNo);
    }

    interface Model extends IModel {
        Observable<ResultBeansEntity<ProductEntity>> doPostBanner();

        Observable<ResultDataEntity<ProductEntity>> doPostShop(int pageNo);

        Observable<List> doLocalBanner();

        Observable<List> doLocalShop(int pageNo);
    }
}
