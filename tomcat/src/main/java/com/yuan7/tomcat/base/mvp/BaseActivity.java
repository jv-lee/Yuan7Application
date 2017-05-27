package com.yuan7.tomcat.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.yuan7.tomcat.base.app.App;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.utils.StatusBarUtils;
import com.yuan7.tomcat.widget.swipe.SwipeBackActivityBase;
import com.yuan7.tomcat.widget.swipe.SwipeBackActivityHelper;
import com.yuan7.tomcat.widget.swipe.SwipeBackLayout;
import com.yuan7.tomcat.widget.swipe.SwipeBackUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/10.
 */

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements SwipeBackActivityBase {
    protected final String TAG = this.getClass().getSimpleName();
    private Unbinder unBinder;

    //声明swipe布局属性
    protected SwipeBackLayout mSwipeBackLayout;
    protected SwipeBackActivityHelper mHelper;

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

        //获取swipe
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
        mSwipeBackLayout = getSwipeBackLayout();//获取swipe实例

        unBinder = ButterKnife.bind(this);

        setFragment();

        setupActivityComponent(mApplication.getAppComponent());
        bindData();
    }

    /**
     * 以下5个为 退出swipe 必备函数
     *
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        SwipeBackUtils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }


    protected void setFragment() {
    }

    protected abstract int bindRootView();

    protected abstract void bindData();

    protected abstract void setupActivityComponent(AppComponent appComponent);


}
