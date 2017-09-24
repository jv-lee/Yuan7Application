package com.yuan7.tomcat.ui.main.info.hot;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.BannerEntity;
import com.yuan7.tomcat.bean.impl.ContentEntity;
import com.yuan7.tomcat.utils.LogUtil;

import javax.inject.Inject;

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
        mModel.doPostBanner()
                .subscribe(new Observer<BannerEntity<ContentEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(BannerEntity<ContentEntity> bannerEntity2) {
                        mView.bindBannerData(bannerEntity2);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.bindDataEvent(0, e.getMessage());
                        LogUtil.getStackTraceString(e);
                        LogUtil.e(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void bindHotData(final int pageNo) {
        mModel.doPostHot(pageNo).subscribe(new Observer<ResultDataEntity<ContentEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (d.isDisposed()) {
                    d.dispose();
                }
            }

            @Override
            public void onNext(ResultDataEntity<ContentEntity> resultEntity) {
                for (int i = 0; i < resultEntity.getObj().getRows().size(); i++) {
                    ((ContentEntity) resultEntity.getObj().getRows().get(i)).setHasAd(true);
                }
                mView.bindHotData(pageNo, resultEntity);
            }

            @Override
            public void onError(Throwable e) {
                mView.bindDataEvent(0, e.getMessage());
                LogUtil.getStackTraceString(e);
                LogUtil.e(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
//        mModel.doLocalHot(pageNo)
//                .subscribe(new Observer<List<HotEntity>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        if (d.isDisposed()) {
//                            d.dispose();
//                        }
//                    }
//
//                    @Override
//                    public void onNext(List<HotEntity> hotEntities) {
//                        mView.bindHotData(hotEntities);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
