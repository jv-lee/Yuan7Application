package com.yuan7.tomcat.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;


import com.yuan7.tomcat.base.app.App;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.utils.StatusBarUtils;
import com.yuan7.tomcat.widget.back.IosBackActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/10.
 */

public abstract class BaseActivity<P extends IPresenter> extends IosBackActivity {
    protected final String TAG = this.getClass().getSimpleName();
    private Unbinder unBinder;


    @Inject
    protected P mPresenter;
    protected Context mContext;
    protected App mApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (App) getApplication();
        mContext = this;
        StatusBarUtils.setStatusBar(this);//设置隐藏状态栏

        setContentView(bindRootView());

        unBinder = ButterKnife.bind(this);

        setFragment();

        setupActivityComponent(mApplication.getAppComponent());
        bindData();
    }



    protected void setFragment() {
    }

    protected abstract int bindRootView();

    protected abstract void bindData();

    protected abstract void setupActivityComponent(AppComponent appComponent);


}
