package com.yuan7.tomcat.ui.menu.shop;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.ShopBannerEntity;
import com.yuan7.tomcat.entity.ShopEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/25.
 */

public interface ShopContract {
    interface View extends IView {
        void bindBannerData(List<ShopBannerEntity> result, List<String> images);

        void bindShopData(List<ShopEntity> result);

        void bindDataEvent(int code, String Shop);
    }

    interface Presenter extends IPresenter {
        void bindBannerData();

        void bindShopData(int pageNo);
    }

    interface Model extends IModel {
        Observable<List<ShopBannerEntity>> doGetBanner();

        Observable<List<ShopEntity>> doGetShop(int pageNo);

        Observable<List<ShopBannerEntity>> doLocalBanner();

        Observable<List<ShopEntity>> doLocalShop(int pageNo);
    }
}
