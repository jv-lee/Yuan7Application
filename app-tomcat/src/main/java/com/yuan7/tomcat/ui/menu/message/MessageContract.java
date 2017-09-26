package com.yuan7.tomcat.ui.menu.message;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.MessageEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/25.
 */

public interface MessageContract {
    interface View extends IView {
        void bindMessageData(int pageNo, ResultDataEntity<MessageEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindMessageData(int pageNo, int type);
    }

    interface Model extends IModel {
        Observable<ResultDataEntity<MessageEntity>> doPostMessage(int pageNo, int type);

        Observable<List<MessageEntity>> doLocalMessage(int pageNo);
    }
}
