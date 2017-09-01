package com.yuan7.tomcat.ui.menu.post.send;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.SendEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/29.
 */

public interface SendContract {
    interface View extends IView {
        void bindSendData(List<SendEntity> result);

        void bindDataEvent(int code, String Shop);
    }

    interface Presenter extends IPresenter {
        void bindSendData(int pageNo);
    }

    interface Model extends IModel {
        Observable<List<SendEntity>> doGetSend(int pageNo);

        Observable<List<SendEntity>> doLocalSend(int pageNo);
    }
}
