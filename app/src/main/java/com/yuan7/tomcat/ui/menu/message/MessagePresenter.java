package com.yuan7.tomcat.ui.menu.message;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.MessageEntity;
import com.yuan7.tomcat.utils.LogUtil;


import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/25.
 */
@ActivityScope
public class MessagePresenter extends BasePresenter<MessageContract.Model, MessageContract.View> implements MessageContract.Presenter {

    @Inject
    public MessagePresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindMessageData(final int pageNo, int type) {
        mModel.doPostMessage(pageNo, type)
                .subscribe(new Observer<ResultEntity<MessageEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultEntity<MessageEntity> messageEntityResultEntity) {
                        mView.bindMessageData(pageNo, messageEntityResultEntity);
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
//        mModel.doLocalMessage(pageNo).subscribe(new Observer<List<MessageEntity>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                if (d.isDisposed()) {
//                    d.dispose();
//                }
//            }
//
//            @Override
//            public void onNext(List<MessageEntity> messageEntities) {
//                mView.bindMessageData(messageEntities);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }
}
