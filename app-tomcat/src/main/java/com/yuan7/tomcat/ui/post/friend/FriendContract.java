package com.yuan7.tomcat.ui.post.friend;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.ResultBeanEntity;
import com.yuan7.tomcat.entity.impl.FriendEntity;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/21.
 */

public interface FriendContract {
    interface View extends IView {
        void bindFriendData(ResultBeanEntity<FriendEntity> resultEntity);

        void addFriendSuccess(String message);

        void addFriendError(String message);
    }

    interface Presenter extends IPresenter {
        void bindFriendData(int userID);

        void addFriend(int userID);
    }

    interface Model extends IModel {
        Observable<ResultBeanEntity<Boolean>> doPostAddFriend(int userID);

        Observable<ResultBeanEntity<FriendEntity>> doPostFriendData(int userID);
    }
}
