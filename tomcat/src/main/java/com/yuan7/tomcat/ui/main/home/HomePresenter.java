package com.yuan7.tomcat.ui.main.home;

import android.util.Log;

import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.BannerBean;
import com.yuan7.tomcat.bean.impl.NewsBean;
import com.yuan7.tomcat.bean.impl.ProPagateBean;

import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/5/17.
 */
@ActivityScope
public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View> implements HomeContract.Presenter {

    @Inject
    public HomePresenter() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void bindBannerData() {
        mModel.doGetBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        List<String> images = new ArrayList<>();
                        for (BannerBean.ResultBean bean : bannerBean.getResult()) {
                            Log.e("image:", ServiceModule.BASE_URL + bean.getImgUrl());
                            images.add(ServiceModule.BASE_URL + bean.getImgUrl());
                        }
                        mView.bindBannerData(bannerBean.getResult(), images);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.bindDataEvent(0, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void bindPropagateData() {
        mModel.doGetProPatate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProPagateBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.bindDataEvent(0, e.getMessage());
                    }

                    @Override
                    public void onNext(ProPagateBean proPagateBean) {
                        mView.bindPropagateData(proPagateBean.getResult());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void bindNewsData(final int pageNo) {
        mModel.doGetNews(pageNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.bindDataEvent(0, e.getMessage());
                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        mView.bindNewsData(pageNo, newsBean);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
