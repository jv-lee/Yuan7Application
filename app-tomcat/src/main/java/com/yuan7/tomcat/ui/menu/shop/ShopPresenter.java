package com.yuan7.tomcat.ui.menu.shop;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultBeanEntity;
import com.yuan7.tomcat.bean.ResultBeansEntity;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.ProductEntity;
import com.yuan7.tomcat.entity.ShopBannerEntity;
import com.yuan7.tomcat.utils.LogUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/25.
 */
@ActivityScope
public class ShopPresenter extends BasePresenter<ShopContract.Model, ShopContract.View> implements ShopContract.Presenter {

    @Inject
    public ShopPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindBannerData() {
        mModel.doPostBanner().subscribe(new Observer<ResultBeansEntity<ProductEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (d.isDisposed()) {
                    d.dispose();
                }
            }

            @Override
            public void onNext(ResultBeansEntity<ProductEntity> shopBannerEntities) {
                mView.bindBannerData(shopBannerEntities);
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
    public void bindShopData(final int pageNo) {
        mModel.doPostShop(pageNo)
                .subscribe(new Observer<ResultDataEntity<ProductEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultDataEntity<ProductEntity> prodouctEntityResultEntity) {
                        mView.bindShopData(pageNo, prodouctEntityResultEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.getStackTraceString(e);
                        LogUtil.e(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
