package com.yuan7.tomcat.ui.login.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.interfaces.LoginInterface;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class RegisterFragment extends BaseFragment {

    @BindView(R.id.iv_left)
    ImageView ivLeft;


    LoginInterface loginInterface;

    public RegisterFragment(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick(R.id.iv_left)
    public void click(View view) {
        loginInterface.setup();
    }

    


}
