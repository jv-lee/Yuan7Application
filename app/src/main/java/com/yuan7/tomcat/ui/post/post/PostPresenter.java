package com.yuan7.tomcat.ui.post.post;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.PostEntity;
import com.yuan7.tomcat.utils.LogUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/29.
 */
@ActivityScope
public class PostPresenter extends BasePresenter<PostContract.Model, PostContract.View> implements PostContract.Presenter {

    @Inject
    public PostPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindSendData(final int pageNo, int userId) {
        mModel.doPostSend(pageNo, userId)
                .subscribe(new Observer<ResultEntity<PostEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultEntity<PostEntity> sendEntityResultEntity) {
                        mView.bindSendData(pageNo, sendEntityResultEntity);
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
//        mModel.doLocalSend(pageNo).subscribe(new Observer<List<PostEntity>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                if (d.isDisposed()) {
//                    d.dispose();
//                }
//            }
//
//            @Override
//            public void onNext(List<PostEntity> sendEntities) {
//                mView.bindSendData(sendEntities);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                LogUtil.getStackTraceString(e);
//                LogUtil.e(e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }
}
