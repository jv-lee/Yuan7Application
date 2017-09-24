package com.yuan7.tomcat.ui.menu.shop;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.ResultBeanEntity;
import com.yuan7.tomcat.bean.ResultBeansEntity;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.ProductEntity;
import com.yuan7.tomcat.entity.ShopBannerEntity;
import com.yuan7.tomcat.entity.ShopEntity;

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

        Observable<List<ShopBannerEntity>> doLocalBanner();

        Observable<List<ShopEntity>> doLocalShop(int pageNo);
    }
}
