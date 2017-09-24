package com.yuan7.tomcat.ui.main.comm.friend;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.FriendEntity;
import com.yuan7.tomcat.server.ApiServer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/21.
 */
@ActivityScope
public class FriendModel extends BaseModel implements FriendContract.Model {

    @Inject
    ApiServer apiServer;

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";

    @Inject
    public FriendModel() {
    }

    @Override
    public Observable<ResultEntity<FriendEntity>> doPostFriend(int pageNo, int type) {
        return apiServer.doPostFriend(type,pageNo, AppConfig.PAGE_NUMBER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<FriendEntity>> doLocalFriend(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<FriendEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<FriendEntity>> e) throws Exception {
                List<FriendEntity> friendEntitys = new ArrayList<>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
//                        friendEntitys.add(new FriendEntity(i, "userName", url, i, 3));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
//                        friendEntitys.add(new FriendEntity(i, "userName", url, i, 4));
                    }
                }
                e.onNext(friendEntitys);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
