package com.yuan7.tomcat.ui.main;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.ResultBeanEntity;
import com.yuan7.tomcat.entity.impl.UserMessage;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/22.
 */

public interface MainContract {
    interface View extends IView {

        void bindMenuData(ResultBeanEntity<UserMessage> resultBeanEntity);
    }

    interface Presenter extends IPresenter {
        void firstLogin();

        void bindMenuData();
    }

    interface Model extends IModel {
        Observable<ResultBeanEntity<UserMessage>> doPostMenuData();

        Observable<ResultBeanEntity> doPostFirstLogin();
    }
}
