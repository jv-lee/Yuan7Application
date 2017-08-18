package com.yuan7.tomcat.ui.login;

import android.support.v4.app.FragmentTransaction;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.interfaces.LoginInterface;
import com.yuan7.tomcat.ui.login.fragment.LoginFragment;
import com.yuan7.tomcat.ui.login.fragment.RegisterFragment;

public class LoginActivity extends BaseActivity implements LoginInterface {

    private LoginFragment loginFragment = new LoginFragment(this);
    private RegisterFragment registerFragment = new RegisterFragment(this);
    private boolean fragmentFlag = true;

    @Override
    protected int bindRootView() {
        return R.layout.activity_login;
    }

    @Override
    protected void bindData() {
        setBackEnable(false);
        setFinishFlag(false);
        startFragment();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    public void startFragment() {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        if (fragmentFlag) {
            fragmentFlag = false;
            ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out);
            ft.replace(R.id.login_container, loginFragment).commit();
        } else {
            fragmentFlag = true;
            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_right_out);
            ft.replace(R.id.login_container, registerFragment).commit();
        }
    }

    public boolean hasFragmentFlag() {
        return fragmentFlag;
    }

    @Override
    public boolean hasFlag() {
        return hasFragmentFlag();
    }

    @Override
    public void setup() {
        startFragment();
    }
}
