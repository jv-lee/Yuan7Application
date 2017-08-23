package com.yuan7.tomcat.ui.control;


import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;

public class ControlActivity extends BaseActivity {


    @Override
    protected int bindRootView() {
        return R.layout.activity_control;
    }

    @Override
    protected void bindData() {
        mFragmentManager.beginTransaction().replace(R.id.control_container, new MyPostFragment()).commit();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }
}
