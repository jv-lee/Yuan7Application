package com.yuan7.tomcat.ui.post.friend;

import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultBeanEntity;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.FriendEntity;
import com.yuan7.tomcat.server.ApiServer;
import com.yuan7.tomcat.utils.SPUtil;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/9/21.
 */
@ActivityScope
public class FriendModel extends BaseModel implements FriendContract.Model {
    @Inject
    ApiServer apiServer;

    @Inject
    public FriendModel() {
    }

    @Override
    public Observable<ResultBeanEntity<Boolean>> doPostAddFriend(int userID) {
        return apiServer.doPostAddFriend((int) SPUtil.get(UserParams.USER_ID, 0), userID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ResultBeanEntity<FriendEntity>> doPostFriendData(int userID) {
        return apiServer.doPostCheckUser(userID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
