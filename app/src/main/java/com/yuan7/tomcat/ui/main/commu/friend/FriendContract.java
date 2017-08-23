package com.yuan7.tomcat.ui.main.commu.friend;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.FriendEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/21.
 */

public interface FriendContract {
    interface View extends IView {
        void bindFriendData(List<FriendEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindFriendData(int pageNo);
    }

    interface Model extends IModel {
        Observable<List<FriendEntity>> doGetFriend(int pageNo);

        Observable<List<FriendEntity>> doLocalFriend(int pageNo);
    }
}
