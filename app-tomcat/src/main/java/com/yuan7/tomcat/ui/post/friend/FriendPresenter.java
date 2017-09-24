package com.yuan7.tomcat.ui.post.friend;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultBeanEntity;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.FriendEntity;
import com.yuan7.tomcat.utils.LogUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/9/21.
 */
@ActivityScope
public class FriendPresenter extends BasePresenter<FriendContract.Model, FriendContract.View> implements FriendContract.Presenter {

    @Inject
    public FriendPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindFriendData(int userID) {
        mModel.doPostFriendData(userID)
                .subscribe(new Observer<ResultBeanEntity<FriendEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultBeanEntity<FriendEntity> resultEntity) {
                        mView.bindFriendData(resultEntity);
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
    }

    @Override
    public void addFriend(int userID) {
        mModel.doPostAddFriend(userID)
                .subscribe(new Observer<ResultBeanEntity<Boolean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultBeanEntity<Boolean> resultEntity) {
                        if (resultEntity.getObj()) {
                            mView.addFriendSuccess(resultEntity.getMessage());
                        } else {
                            mView.addFriendError(resultEntity.getMessage());
                        }
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
    }
}
