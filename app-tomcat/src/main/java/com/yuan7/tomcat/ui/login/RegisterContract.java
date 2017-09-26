package com.yuan7.tomcat.ui.login;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.impl.UserEntity;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/9/8.
 */

public interface RegisterContract {
    interface View extends IView {
        void registerProgressShow();

        void registerProgressHide();

        void registerSuccess();

        void registerError(int code, String message);
    }

    interface Presenter extends IPresenter {
        void register(String username,String password,String rePassword);
    }

    interface Model extends IModel {
        Observable<Response<UserEntity>> doPostRegister(String username,String password);
    }
}
