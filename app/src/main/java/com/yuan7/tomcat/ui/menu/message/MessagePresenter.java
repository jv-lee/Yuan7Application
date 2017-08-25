package com.yuan7.tomcat.ui.menu.message;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.MessageEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/25.
 */
@ActivityScope
public class MessagePresenter extends BasePresenter<MessageContract.Model,MessageContract.View> implements MessageContract.Presenter{

    @Inject
    public MessagePresenter(){}

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindMessageData(int pageNo) {
        mModel.doLocalMessage(pageNo).subscribe(new Observer<List<MessageEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (d.isDisposed()) {
                    d.dispose();
                }
            }

            @Override
            public void onNext(List<MessageEntity> messageEntities) {
                mView.bindMessageData(messageEntities);
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
