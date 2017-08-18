package com.yuan7.tomcat.ui.main.info.video;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.VideoEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/15.
 */
@ActivityScope
public class VideoPresenter extends BasePresenter<VideoContract.Model, VideoContract.View> implements VideoContract.Presenter {

    @Inject
    public VideoPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindVideoData(int pageNo) {
        mModel.doLocalVideo(pageNo)
                .subscribe(new Observer<List<VideoEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(List<VideoEntity> videoEntities) {
                        mView.bindVideoData(videoEntities);
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
