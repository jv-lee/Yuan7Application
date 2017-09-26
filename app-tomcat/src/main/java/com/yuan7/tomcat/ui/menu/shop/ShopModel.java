package com.yuan7.tomcat.ui.menu.shop;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultBeansEntity;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.ProductEntity;
import com.yuan7.tomcat.server.ApiServer;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/25.
 */
@ActivityScope
public class ShopModel extends BaseModel implements ShopContract.Model {

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";
    @Inject
    ApiServer apiServer;

    @Inject
    public ShopModel() {
    }

    @Override
    public Observable<ResultBeansEntity<ProductEntity>> doPostBanner() {
        return apiServer.doPostProductBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ResultDataEntity<ProductEntity>> doPostShop(int pageNo) {
        return apiServer.doPostProduct(pageNo, AppConfig.PAGE_NUMBER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List> doLocalBanner() {
        return null;
    }

    @Override
    public Observable<List> doLocalShop(final int pageNo) {
        return null;
    }
}
