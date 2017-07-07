package com.yuan7.tomcat.ui.main.video;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.VideoBean;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/5/18.
 */
@ActivityScope
public class VideoPresenter extends BasePresenter<VideoContract.Model, VideoContract.View> implements VideoContract.Presenter {

    @Inject
    public VideoPresenter() {

    }

    @Override
    public void onDestroy() {
        mView = null;
        mModel = null;
    }

    @Override
    public void bindVideoData(final int pageNo) {
        mModel.doGetVideo(pageNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.bindDataEvent(0, e.getMessage());
                    }

                    @Override
                    public void onNext(VideoBean bean) {
                        mView.bindVideoData(pageNo, bean);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
