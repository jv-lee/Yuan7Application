package com.yuan7.tomcat.ui.menu.message;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.MessageEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/25.
 */

public interface MessageContract {
    interface View extends IView {
        void bindMessageData(List<MessageEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindMessageData(int pageNo);
    }

    interface Model extends IModel {
        Observable<List<MessageEntity>> doGetMessage(int pageNo);

        Observable<List<MessageEntity>> doLocalMessage(int pageNo);
    }
}
