package com.yuan7.tomcat.ui.login;

import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.UserEntity;
import com.yuan7.tomcat.utils.LogUtil;
import com.yuan7.tomcat.utils.RegexUtils;
import com.yuan7.tomcat.utils.SPUtil;
import com.yuan7.tomcat.utils.SaveUserUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/9/7.
 */
@ActivityScope
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> implements LoginContract.Presenter {

    @Inject
    public LoginPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void loadIconOrName() {
        String iconUrl = (String) SPUtil.get(UserParams.USER_ICON_URL, "");
        String name = (String) SPUtil.get(UserParams.USER_NAME, "");
        if (!iconUrl.equals("") && !name.equals("")) {
            mView.setIconOrName(iconUrl, name);
        } else {
            mView.setDefaultIconOrName();
        }
    }

    @Override
    public void login(int type, String username, String password) {
        if (type == 0) {
            if (username.equals("")) {
                mView.loginError(0, "请输入账号");
                return;
            } else if (username.length() < 6) {
                mView.loginError(0, "用户名长度不符合");
                return;
            } else if (!RegexUtils.isMatch("^[A-Za-z0-9]+$", username)) {
                mView.loginError(0, "用户名不符合规则");
                return;
            } else if (password.equals("")) {
                mView.loginError(0, "请输入密码");
                return;
            } else if (password.length() < 6) {
                mView.loginError(0, "密码长度不符合");
                return;
            } else if (!RegexUtils.isMatch("^[A-Za-z0-9]+$", password)) {
                mView.loginError(0, "密码不符合规则");
                return;
            }
        }

        mView.loginProgressShow();

        mModel.doPostLogin(type, username, password)
                .subscribeOn(Schedulers.io())
                .map(new Function<Response<UserEntity>, UserEntity>() {
                    @Override
                    public UserEntity apply(@NonNull Response<UserEntity> userEntityResponse) throws Exception {
                        LogUtil.i(userEntityResponse.headers().toString() == null ? "null" : userEntityResponse.headers().toString());
                        if (userEntityResponse.body() != null) {
                            if (userEntityResponse.body().getCode() == 2000) {
                                SaveUserUtil.saveUserSP(userEntityResponse);
                            }
                        }
                        return userEntityResponse.body();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        if (userEntity.getCode() == 2000) {
                            mView.loginProgressHide();
                            mView.loginSuccess();
                        } else {
                            mView.loginProgressHide();
                            mView.loginError(1, userEntity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.getStackTraceString(e);
                        LogUtil.e(e.getMessage());
                        mView.loginProgressHide();
                        mView.loginError(2, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void flyLogin() {
        mView.loginProgressShow();

        mModel.doPostFlyLogin()
                .subscribeOn(Schedulers.io())
                .map(new Function<Response<UserEntity>, UserEntity>() {
                    @Override
                    public UserEntity apply(@NonNull Response<UserEntity> userEntityResponse) throws Exception {
                        LogUtil.i(userEntityResponse.headers().toString() == null ? "null" : userEntityResponse.headers().toString());
                        if (userEntityResponse.body() != null) {
                            if (userEntityResponse.body().getCode() == 2000) {
                                SaveUserUtil.saveUserSP(userEntityResponse);
                            }
                        }
                        return userEntityResponse.body();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        if (userEntity.getCode() == 2000) {
                            mView.loginProgressHide();
                            mView.loginSuccess();
                        } else {
                            mView.loginProgressHide();
                            mView.loginError(1, userEntity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.getStackTraceString(e);
                        LogUtil.e(e.getMessage());
                        mView.loginProgressHide();
                        mView.loginError(2, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
