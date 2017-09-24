package com.yuan7.tomcat.ui.main.comm.friend;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.FriendEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/21.
 */

public interface FriendContract {
    interface View extends IView {
        void bindFriendData(int pageNo, ResultEntity<FriendEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindFriendData(int pageNo, int type);
    }

    interface Model extends IModel {
        Observable<ResultEntity<FriendEntity>> doPostFriend(int pageNo, int type);

        Observable<List<FriendEntity>> doLocalFriend(int pageNo);
    }
}
