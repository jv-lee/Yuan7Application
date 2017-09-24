package com.yuan7.tomcat.ui.menu.shop;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultBeanEntity;
import com.yuan7.tomcat.bean.ResultBeansEntity;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.ProductEntity;
import com.yuan7.tomcat.entity.ShopBannerEntity;
import com.yuan7.tomcat.entity.ShopEntity;
import com.yuan7.tomcat.server.ApiServer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
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
    public Observable<List<ShopBannerEntity>> doLocalBanner() {
        return Observable.create(new ObservableOnSubscribe<List<ShopBannerEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ShopBannerEntity>> e) throws Exception {
                List<ShopBannerEntity> bannerEntities = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    bannerEntities.add(new ShopBannerEntity(i, "第" + i + "个banner", url));
                }
                e.onNext(bannerEntities);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<ShopEntity>> doLocalShop(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<ShopEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ShopEntity>> e) throws Exception {
                List<ShopEntity> shopEntities = new ArrayList<>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
                        shopEntities.add(new ShopEntity(i, "价值100元京东卡", 50000, url));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
                        shopEntities.add(new ShopEntity(i, "价值100元淘宝卡", 50000, url));
                    }
                }
                e.onNext(shopEntities);
                e.onComplete();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
