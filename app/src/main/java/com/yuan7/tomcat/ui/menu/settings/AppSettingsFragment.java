package com.yuan7.tomcat.ui.menu.settings;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
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
public class AppSettingsFragment extends BaseFragment {

    @BindView(R.id.fl_item_font)
    FrameLayout itemFont;
    @BindView(R.id.fl_item_push)
    FrameLayout itemPush;
    @BindView(R.id.fl_item_message)
    FrameLayout itemMessage;
    @BindView(R.id.fl_item_wifi)
    FrameLayout itemWifi;
    @BindView(R.id.fl_item_update)
    FrameLayout itemUpdate;
    @BindView(R.id.switch_push)
    Switch switchPush;
    @BindView(R.id.switch_message)
    Switch switchMessage;
    @BindView(R.id.switch_wifi)
    Switch switchWifi;
    @BindView(R.id.tv_font)
    TextView tvFont;


    private MenuTitleBarListener listener;

    public AppSettingsFragment(MenuTitleBarListener listener) {
        this.listener = listener;
    }


    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_app_settings, container, false);
    }

    @Override
    protected void bindData() {
        listener.setTitleText(Constant.MENU_TITLE_APP_SETTINGS);
    }

    @Override
    protected void lazyLoad() {

    }


    @OnClick({R.id.fl_item_font, R.id.fl_item_push,R.id.fl_item_message,R.id.fl_item_wifi,R.id.fl_item_update})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.fl_item_font:
                tvFont.setText("中");
                break;
            case R.id.fl_item_push:
                switchPush.setChecked(!switchPush.isChecked());
                break;
            case R.id.fl_item_message:
                switchMessage.setChecked(!switchMessage.isChecked());
                break;
            case R.id.fl_item_wifi:
                switchWifi.setChecked(!switchWifi.isChecked());
                break;
            case R.id.fl_item_update:
                Toast.makeText(mActivity, "update", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
