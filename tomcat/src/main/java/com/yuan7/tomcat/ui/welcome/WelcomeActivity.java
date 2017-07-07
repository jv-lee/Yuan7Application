package com.yuan7.tomcat.ui.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;
import com.yuan7.tomcat.Config;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.App;
import com.yuan7.tomcat.bean.impl.IsOpenBean;
import com.yuan7.tomcat.service.ApiService;
import com.yuan7.tomcat.ui.main.MainActivity;
import com.yuan7.tomcat.ui.welcome.inject.DaggerWelcomeComponent;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WelcomeActivity extends Activity {

    @Inject
    ApiService service;

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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Long aLong) {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        service.isOpen(Config.APP_ID)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<IsOpenBean>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(IsOpenBean isOpenBean) {
                                        Config.TAB_TAG = isOpenBean.getIsOpen();
                                        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                                        finish();
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        Config.TAB_TAG = Config.getOpenTag();
                                        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                                        finish();
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
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
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onResume(this);
    }

}
