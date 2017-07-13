package com.yuan7.tomcat.ui.content.app;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.DetailBean;
import com.yuan7.tomcat.bean.impl.HotAdBean;

import org.reactivestreams.Subscriber;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/5/25.
 */
@ActivityScope
public class AppDataPresenter extends BasePresenter<AppDataContract.Model, AppDataContract.View> implements AppDataContract.Presenter {

    @Inject
    public AppDataPresenter() {
    }

    @Override
    public void onDestroy() {
        if (mView != null) {
            mView = null;
        }
        if (mModel != null) {
            mModel = null;
        }
    }

    @Override
    public void bindDetailData(String id) {
        mModel.doGetDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.bindDataEvent(0, e.getMessage());
                    }

                    @Override
                    public void onNext(DetailBean bean) {
                        mView.bindDetailData(bean);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void bindHotData() {
        mModel.doGetHot()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotAdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.bindDataEvent(0, e.getMessage());
                    }

                    @Override
                    public void onNext(HotAdBean bean) {
                        mView.bindHotData(bean);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
