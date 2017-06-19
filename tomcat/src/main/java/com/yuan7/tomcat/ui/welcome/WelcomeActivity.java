package com.yuan7.tomcat.ui.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.yuan7.tomcat.Config;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.App;
import com.yuan7.tomcat.bean.impl.IsOpenBean;
import com.yuan7.tomcat.service.ApiService;
import com.yuan7.tomcat.ui.main.MainActivity;
import com.yuan7.tomcat.ui.welcome.inject.DaggerWelcomeComponent;
import com.yuan7.tomcat.utils.StatusBarUtils;

import org.reactivestreams.Subscriber;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class WelcomeActivity extends AppCompatActivity {

    @Inject
    ApiService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setStatusBar(this);//设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, //设置隐藏状态栏
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        registerDagger();
        bindData();
    }

    private void bindData() {

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
                        service.isOpen()
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

}
