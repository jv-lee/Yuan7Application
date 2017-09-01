package com.yuan7.tomcat.ui.main.comm.friend;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.FriendEntity;

import java.util.List;

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
    public void bindFriendData(int pageNo) {
        mModel.doLocalFriend(pageNo)
                .subscribe(new Observer<List<FriendEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(List<FriendEntity> friendEntities) {
                        mView.bindFriendData(friendEntities);
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
