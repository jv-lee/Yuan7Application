package com.yuan7.tomcat.ui.menu.shop;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ShopBannerEntity;
import com.yuan7.tomcat.entity.ShopEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/25.
 */
@ActivityScope
public class ShopPresenter extends BasePresenter<ShopContract.Model,ShopContract.View> implements ShopContract.Presenter{

    @Inject
    public ShopPresenter(){}

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindBannerData() {
        mModel.doLocalBanner().subscribe(new Observer<List<ShopBannerEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (d.isDisposed()) {
                    d.dispose();
                }
            }

            @Override
            public void onNext(List<ShopBannerEntity> shopBannerEntities) {
                mView.bindBannerData(shopBannerEntities,null);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void bindShopData(int pageNo) {
        mModel.doLocalShop(pageNo).subscribe(new Observer<List<ShopEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (d.isDisposed()) {
                    d.dispose();
                }
            }

            @Override
            public void onNext(List<ShopEntity> shopEntities) {
                mView.bindShopData(shopEntities);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
