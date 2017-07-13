package com.yuan7.tomcat.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.yuan7.tomcat.base.app.App;
import com.yuan7.tomcat.base.app.AppComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/10.
 */

public abstract class BaseFragment<P extends IPresenter> extends Fragment {
    protected final String TAG = this.getClass().getSimpleName();
    protected BaseActivity mActivity;
    protected View mRootView;
    protected boolean isVisibleUser = false;
    protected boolean isVisibleView = false;
    protected boolean fistVisible = true;

    @Inject
    protected P mPresenter;
    private Unbinder unBinder;

    public BaseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = bindRootView(inflater, container, savedInstanceState);
        unBinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
        componentInject(((App) getActivity().getApplication()).getAppComponent());
        bindData();
        isVisibleView = true;
        if (isVisibleView == true && isVisibleUser == true && fistVisible) {
            fistVisible = false;
            lazyLoad();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isVisibleUser = true;
            onFragmentResume();
            //首次用户可见 开始加载数据
            if (isVisibleView == true && isVisibleUser == true && fistVisible) {
                fistVisible = false;
                lazyLoad();
            }
        } else {
            isVisibleUser = false;
            onFragmentPause();
        }
    }

    protected void onFragmentResume() {

    }

    protected void onFragmentPause() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unBinder != unBinder.EMPTY) {
            unBinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }

    protected abstract void componentInject(AppComponent appComponent);

    protected abstract View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void bindData();

    protected abstract void lazyLoad();

}
