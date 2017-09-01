package com.yuan7.tomcat.ui.menu;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.interfaces.TitleBarListener;
import com.yuan7.tomcat.ui.menu.message.MessageFragment;
import com.yuan7.tomcat.ui.menu.settings.AppSettingsFragment;
import com.yuan7.tomcat.ui.menu.settings.UserSettingsFragment;
import com.yuan7.tomcat.ui.menu.shop.ShopFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MenuActivity extends BaseActivity implements TitleBarListener {

    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected int bindRootView() {
        return R.layout.activity_menu;
    }

    @Override
    protected void bindData() {
        String mode = getIntent().getStringExtra(Constant.MENU_DATE_TAG);
        switch (mode) {
            case Constant.MENU_MESSAGE:
                mFragmentManager.beginTransaction().replace(R.id.control_container, new MessageFragment(this)).commit();
                break;
            case Constant.MENU_SHOP:
                mFragmentManager.beginTransaction().replace(R.id.control_container, new ShopFragment(this)).commit();
                break;
            case Constant.MENU_APP_SETTINGS:
                mFragmentManager.beginTransaction().replace(R.id.control_container, new AppSettingsFragment(this)).commit();
                break;
            case Constant.MENU_USER_SETTINGS:
                mFragmentManager.beginTransaction().replace(R.id.control_container, new UserSettingsFragment(this)).commit();
                break;
        }
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
    }

    @Override
    public void setTitleText(String text) {
        tvTitle.setText(text);
    }

    @OnClick(R.id.iv_left)
    public void onclick(View view) {
        finish();
    }
}
