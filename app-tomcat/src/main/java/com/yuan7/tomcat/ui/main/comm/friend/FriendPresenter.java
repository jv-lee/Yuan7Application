package com.yuan7.tomcat.ui.main.comm.friend;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.FriendEntity;
import com.yuan7.tomcat.utils.LogUtil;


import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/21.
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
    public void bindFriendData(final int pageNo, int type) {
        mModel.doPostFriend(pageNo,type)
                .subscribe(new Observer<ResultDataEntity<FriendEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultDataEntity<FriendEntity> resultEntity) {
                        mView.bindFriendData(pageNo,resultEntity);
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

//        mModel.doLocalFriend(pageNo)
//                .subscribe(new Observer<List<FriendEntity>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        if (d.isDisposed()) {
//                            d.dispose();
//                        }
//                    }
//
//                    @Override
//                    public void onNext(List<FriendEntity> friendEntities) {
//                        mView.bindFriendData(friendEntities);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
