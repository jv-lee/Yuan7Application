package com.yuan7.tomcat.ui.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.base.app.App;
import com.yuan7.tomcat.server.ApiServer;
import com.yuan7.tomcat.ui.login.LoginActivity;
import com.yuan7.tomcat.ui.main.MainActivity;
import com.yuan7.tomcat.ui.welcome.inject.DaggerWelcomeComponent;
import com.yuan7.tomcat.utils.SPUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class WelcomeActivity extends Activity {

    @Inject
    ApiServer service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        registerDagger();
        bindData();
    }

    private void bindData() {
        //2s 记时跳转
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .map(new Function<Long, Boolean>() {
                    @Override
                    public Boolean apply(@NonNull Long aLong) throws Exception {
                        boolean loginFlag = (boolean) SPUtil.get(UserParams.LOGIN_STATUS, false);
                        return loginFlag;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                        }else{
                            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                        }
                        finish();
                    }
                });
    }


    private void registerDagger() {
        DaggerWelcomeComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
