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
import android.widget.ImageView;
import android.widget.TextView;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.interfaces.LoginInterface;
import com.yuan7.tomcat.ui.login.RegisterContract;
import com.yuan7.tomcat.ui.login.inject.DaggerRegisterComponent;
import com.yuan7.tomcat.ui.login.inject.RegisterModule;
import com.yuan7.tomcat.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class RegisterFragment extends BaseFragment<RegisterContract.Presenter> implements RegisterContract.View {

    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.et_userName)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_rePassword)
    EditText etRePassword;
    @BindView(R.id.btn_register_ok)
    Button btnRegister;

    SweetAlertDialog pDialog = null;

    LoginInterface loginInterface;

    public RegisterFragment(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerRegisterComponent.builder()
                .appComponent(appComponent)
                .registerModule(new RegisterModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    protected void bindData() {
        pDialog = new SweetAlertDialog(mActivity, SweetAlertDialog.PROGRESS_TYPE);//创建登陆进度Alert
        pDialog.getProgressHelper().setBarColor(mActivity.getColor(R.color.colorPrimary));
        pDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        pDialog.setCancelable(false);
        pDialog.setTitleText("Loading");
    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick({R.id.tv_back, R.id.btn_register_ok})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                loginInterface.setup();
                break;
            case R.id.btn_register_ok:
                mPresenter.register(etUsername.getText().toString(), etPassword.getText().toString(), etRePassword.getText().toString());
                break;
        }
    }

    @Override
    public void registerProgressShow() {
        pDialog.show();
    }

    @Override
    public void registerProgressHide() {
        pDialog.hide();
    }

    @Override
    public void registerSuccess() {
        startActivity(new Intent(mActivity, MainActivity.class));
        mActivity.finish();
    }

    @Override
    public void registerError(int code, String message) {
        switch (code) {
            case 0:
                showErrorDialog(message);
                break;
            case 1:
                showErrorDialog(message);
                break;
            case 2:
                showErrorDialog(message);
                break;
        }
    }

    public void showErrorDialog(String message) {
        new SweetAlertDialog(mActivity, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(message)
                .show();
    }
}
