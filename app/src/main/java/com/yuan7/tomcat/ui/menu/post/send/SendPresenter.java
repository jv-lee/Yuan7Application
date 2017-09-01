package com.yuan7.tomcat.ui.menu.post.send;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.SendEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/29.
 */
@ActivityScope
public class SendPresenter extends BasePresenter<SendContract.Model,SendContract.View> implements SendContract.Presenter{

    @Inject
    public SendPresenter(){}

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindSendData(int pageNo) {
        mModel.doLocalSend(pageNo).subscribe(new Observer<List<SendEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (d.isDisposed()) {
                    d.dispose();
                }
            }

            @Override
            public void onNext(List<SendEntity> sendEntities) {
                mView.bindSendData(sendEntities);
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
