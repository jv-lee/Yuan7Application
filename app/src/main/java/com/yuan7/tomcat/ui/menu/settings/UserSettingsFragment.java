package com.yuan7.tomcat.ui.menu.settings;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.interfaces.MenuTitleBarListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserSettingsFragment extends BaseFragment {

    @BindView(R.id.fl_item_name)
    FrameLayout itemName;
    @BindView(R.id.fl_item_sex)
    FrameLayout itemSex;
    @BindView(R.id.fl_item_birthday)
    FrameLayout itemBirthday;
    @BindView(R.id.fl_item_level)
    FrameLayout itemLevel;
    @BindView(R.id.btn_unLogin)
    Button btnUnLogin;

    private MenuTitleBarListener listener;

    public UserSettingsFragment(MenuTitleBarListener listener) {
        this.listener = listener;
    }


    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_settings, container, false);
    }

    @Override
    protected void bindData() {
        listener.setTitleText(Constant.MENU_TITLE_UESR_SETTINGS);
    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick({R.id.fl_item_name, R.id.fl_item_sex, R.id.fl_item_birthday, R.id.fl_item_level})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.fl_item_name:
                Toast.makeText(mActivity, "name", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fl_item_sex:
                Toast.makeText(mActivity, "sex", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fl_item_birthday:
                Toast.makeText(mActivity, "birthday", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fl_item_level:
                Toast.makeText(mActivity, "level", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
