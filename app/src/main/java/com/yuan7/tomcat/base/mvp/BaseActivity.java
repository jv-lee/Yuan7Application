package com.yuan7.tomcat.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.yuan7.tomcat.base.app.App;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.utils.StatusBarUtil;
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
    protected FragmentManager mFragmentManager;

    private long firstTime = 0;
    private boolean hasBackExit = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBar(this);//设置隐藏状态栏
        mApplication = (App) getApplication();
        mContext = this;
        mFragmentManager = getSupportFragmentManager();


        setContentView(bindRootView());

        unBinder = ButterKnife.bind(this);

        setupActivityComponent(mApplication.getAppComponent());
        bindData();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unBinder != unBinder.EMPTY) {
            unBinder.unbind();
        }
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (hasBackExit) {
                    long secondTime = System.currentTimeMillis();
                    if (secondTime - firstTime > 2000) {//如果两次按键时间间隔大于2秒，则不退出
                        Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                        firstTime = secondTime;//更新firstTime
                        return true;
                    } else {//两次按键小于2秒时，退出应用
                        finish();
                    }
                }
        }
        return super.onKeyUp(keyCode, event);
    }

    protected void backExitEnable(boolean enable) {
        hasBackExit = enable;
    }

    protected abstract int bindRootView();

    protected abstract void bindData();

    protected abstract void setupActivityComponent(AppComponent appComponent);


}
