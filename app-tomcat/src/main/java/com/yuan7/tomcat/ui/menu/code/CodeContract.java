package com.yuan7.tomcat.ui.menu.code;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.ResultBeanEntity;
import com.yuan7.tomcat.bean.impl.UserEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/22.
 */

public interface CodeContract {

    interface View extends IView {
        void sendCodeResponse(ResultBeanEntity resultBeanEntity);

        void bindCodeData(ResultBeanEntity<List<UserEntity>> resultEntity);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindCodeData();

        void sendCodeToServer(String code);
    }

    interface Model extends IModel {
        Observable<ResultBeanEntity> doPostCodeSend(String code);

        Observable<ResultBeanEntity<List<UserEntity>>> doPostCodeList();
    }

}

