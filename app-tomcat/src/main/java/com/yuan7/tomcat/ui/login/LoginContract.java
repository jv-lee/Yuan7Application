package com.yuan7.tomcat.ui.login;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.impl.UserEntity;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/9/7.
 */

public interface LoginContract {
    interface View extends IView {
        void setIconOrName(String iconUrl, String name);

        void setDefaultIconOrName();

        void loginProgressShow();

        void loginProgressHide();

        void loginSuccess();

        void loginError(int code, String message);
    }

    interface Presenter extends IPresenter {
        void loadIconOrName();

        void login(int type, String username, String password);

        void flyLogin();
    }

    interface Model extends IModel {
        Observable<Response<UserEntity>> doPostLogin(int type, String username, String password);

        Observable<Response<UserEntity>> doPostFlyLogin();
    }
}
