package com.yuan7.tomcat.ui.post.reply;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.ReplyEntity;
import com.yuan7.tomcat.utils.LogUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/29.
 */
@ActivityScope
public class ReplyPresenter extends BasePresenter<ReplyContract.Model, ReplyContract.View> implements ReplyContract.Presenter {

    @Inject
    public ReplyPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindReplyData(final int pageNo, int userId) {
        mModel.doPostReply(pageNo, userId)
                .subscribe(new Observer<ResultDataEntity<ReplyEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultDataEntity<ReplyEntity> replyEntityResultEntity) {
                        mView.bindReplyData(pageNo, replyEntityResultEntity);
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
//        mModel.doLocalReply(pageNo)
//                .subscribe(new Observer<List<ReplyEntity>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        if (d.isDisposed()) {
//                            d.dispose();
//                        }
//                    }
//
//                    @Override
//                    public void onNext(List<ReplyEntity> replyEntities) {
//                        mView.bindReplyData(replyEntities);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        LogUtil.getStackTraceString(e);
//                        LogUtil.e(e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
