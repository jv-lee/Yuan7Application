package com.yuan7.tomcat.ui.menu.post.reply;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ReplyEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/29.
 */
@ActivityScope
public class ReplyPresenter extends BasePresenter<ReplyContract.Model,ReplyContract.View> implements ReplyContract.Presenter{

    @Inject
    public ReplyPresenter(){}

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindReplyData(int pageNo) {
        mModel.doLocalReply(pageNo)
                .subscribe(new Observer<List<ReplyEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(List<ReplyEntity> replyEntities) {
                        mView.bindReplyData(replyEntities);
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
