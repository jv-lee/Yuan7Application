package com.yuan7.tomcat.ui.login.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.interfaces.LoginInterface;
import com.yuan7.tomcat.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class LoginFragment extends BaseFragment {

    @BindView(R.id.btn_flyLogin)
    Button btnFlyLogin;
    @BindView(R.id.tv_rightRegister)
    TextView tvRightRegister;

    LoginInterface loginInterface;

    public LoginFragment(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick({R.id.btn_flyLogin, R.id.tv_rightRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_flyLogin:
                startActivity(new Intent(mActivity, MainActivity.class));
                mActivity.finish();
                break;
            case R.id.tv_rightRegister:
                loginInterface.setup();
                break;
        }

    }

}
