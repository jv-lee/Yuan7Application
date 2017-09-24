package com.yuan7.tomcat.ui.login.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.interfaces.LoginInterface;
import com.yuan7.tomcat.ui.login.LoginContract;
import com.yuan7.tomcat.ui.login.inject.DaggerLoginComponent;
import com.yuan7.tomcat.ui.login.inject.LoginModule;
import com.yuan7.tomcat.ui.main.MainActivity;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.widget.roundImageView.RoundedImageView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class LoginFragment extends BaseFragment<LoginContract.Presenter> implements LoginContract.View {

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_flyLogin)
    Button btnFlyLogin;
    @BindView(R.id.tv_rightRegister)
    TextView tvRightRegister;
    @BindView(R.id.tv_userName)
    TextView tvUsername;
    @BindView(R.id.tv_forgetPassword)
    TextView tvForgetPassword;
    @BindView(R.id.iv_icon)
    RoundedImageView rivIcon;
    @BindView(R.id.et_userName)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;

    SweetAlertDialog pDialog = null;

    LoginInterface loginInterface;

    public LoginFragment(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    protected void bindData() {
        pDialog = new SweetAlertDialog(mActivity, SweetAlertDialog.PROGRESS_TYPE);//创建登陆进度Alert
        pDialog.getProgressHelper().setBarColor(mActivity.getResources().getColor(R.color.colorPrimary));
        pDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        pDialog.setCancelable(false);
        pDialog.setTitleText("Loading");

        mPresenter.loadIconOrName();
    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick({R.id.btn_flyLogin, R.id.tv_rightRegister, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_flyLogin:
                mPresenter.flyLogin();
                break;
            case R.id.tv_rightRegister:
                loginInterface.setup();
                break;
            case R.id.btn_login:
                mPresenter.login(0, etUsername.getText().toString(), etPassword.getText().toString());
                break;
        }
    }

    @Override
    public void setIconOrName(String iconUrl, String name) {
        GlideImageLoader.loadCircleCrop(iconUrl, rivIcon);
        tvUsername.setText(name);
        tvUsername.setVisibility(View.VISIBLE);
    }

    @Override
    public void setDefaultIconOrName() {
        rivIcon.setImageResource(R.mipmap.icon);
        tvUsername.setText("");
        tvUsername.setVisibility(View.INVISIBLE);
    }

    @Override
    public void loginProgressShow() {
        pDialog.show();
    }

    @Override
    public void loginProgressHide() {
        pDialog.hide();
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(mActivity, MainActivity.class));
        mActivity.finish();
    }

    @Override
    public void loginError(int code, String message) {
        switch (code) {
            case 0:
                showErrorDialog(message);
                break;
            case 1:
                showErrorDialog(message);
//                Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                showErrorDialog(message);
//                Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void showErrorDialog(String message) {
        new SweetAlertDialog(mActivity, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(message)
                .show();
    }

}
