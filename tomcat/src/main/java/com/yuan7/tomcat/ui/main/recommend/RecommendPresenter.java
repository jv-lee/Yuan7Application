package com.yuan7.tomcat.ui.main.recommend;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.RecommendBean;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/5/18.
 */
@ActivityScope
public class RecommendPresenter extends BasePresenter<RecommendContract.Model, RecommendContract.View> implements RecommendContract.Presenter {

    @Inject
    public RecommendPresenter() {

    }

    @Override
    public void onDestroy() {
        mView = null;
        mModel = null;
    }

    @Override
    public void bindRecommendData(final int pageNo) {
        mModel.doGetRecommend(pageNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecommendBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.bindDataEvent(0, e.getMessage());
                    }

                    @Override
                    public void onNext(RecommendBean recommendBean) {
                        mView.bindRecommendData(pageNo, recommendBean);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
