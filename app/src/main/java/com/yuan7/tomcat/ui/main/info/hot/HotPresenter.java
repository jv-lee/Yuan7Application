package com.yuan7.tomcat.ui.main.info.hot;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.BannerEntity;
import com.yuan7.tomcat.entity.HotEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/15.
 */
@ActivityScope
public class HotPresenter extends BasePresenter<HotContract.Model, HotContract.View> implements HotContract.Presenter {

    @Inject
    public HotPresenter() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void bindBannerData() {
        mModel.doLocalBanner()
                .subscribe(new Observer<List<BannerEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(List<BannerEntity> bannerEntities) {
                        mView.bindBannerData(bannerEntities, null);
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
    public void bindHotData(int pageNo) {
        mModel.doLocalHot(pageNo)
                .subscribe(new Observer<List<HotEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(List<HotEntity> hotEntities) {
                        mView.bindHotData(hotEntities);
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
