package com.yuan7.tomcat.ui.main;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.ui.menu.MenuActivity;
import com.yuan7.tomcat.ui.menu.post.MyPostActivity;
import com.yuan7.tomcat.ui.main.commu.CommuFragment;
import com.yuan7.tomcat.ui.main.info.InfoFragment;
import com.yuan7.tomcat.ui.main.start.StartFragment;
import com.yuan7.tomcat.widget.BottomNavigationViewEx;
import com.yuan7.tomcat.widget.NoScrollViewPager;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_container)
    NoScrollViewPager mainContainer;
    @BindView(R.id.main_nav)
    BottomNavigationViewEx mainNav;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    //侧滑菜单项
    @BindView(R.id.tv_friend)
    TextView tvFriend;
    @BindView(R.id.tv_post)
    TextView tvPost;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.tv_shop)
    TextView tvShopHome;
    @BindView(R.id.tv_userSettings)
    TextView tvUserSettings;
    @BindView(R.id.tv_appSettings)
    TextView tvAppSettings;

    private Fragment[] fragments = {new InfoFragment(), new CommuFragment(), new StartFragment()};
    private String mode = "";
    private boolean itemFlag = false;


    @Override
    protected int bindRootView() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindData() {
        setBackEnable(false);
        setFinishFlag(false);
        backExitEnable(true);
        mainNav.enableAnimation(false);
        mainContainer.setAdapter(new UiPagerAdapter(mFragmentManager, fragments));
        mainContainer.setNoScroll(true);
        mainContainer.setOffscreenPageLimit(fragments.length - 1);
        mainNav.setupWithViewPager(mainContainer);

        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                startMenuItem();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    public void openDrawer() {
        drawer.openDrawer(Gravity.START);
    }

    @OnClick({R.id.tv_friend,R.id.tv_post,R.id.tv_message,R.id.tv_shop,R.id.tv_userSettings,R.id.tv_appSettings})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_friend:
                mode = Constant.MENU_FRIEND;
                break;
            case R.id.tv_post:
                mode = Constant.MENU_POST;
                break;
            case R.id.tv_message:
                mode = Constant.MENU_MESSAGE;
                break;
            case R.id.tv_shop:
                mode = Constant.MENU_SHOP;
                break;
            case R.id.tv_userSettings:
                mode = Constant.MENU_USER_SETTINGS;
                break;
            case R.id.tv_appSettings:
                mode = Constant.MENU_APP_SETTINGS;
                break;
        }
        itemFlag = true;
        drawer.closeDrawer(Gravity.START);
    }

    public void startMenuItem(){
        if (!itemFlag) {
            return;
        }
        itemFlag = false;
        switch (mode) {
            case Constant.MENU_FRIEND:
                Toast.makeText(mContext, "friend", Toast.LENGTH_SHORT).show();
                break;
            case Constant.MENU_POST:
                startActivity(new Intent(this,MyPostActivity.class));
                break;
            case Constant.MENU_MESSAGE:
                startActivity(new Intent(this, MenuActivity.class).putExtra(Constant.MENU_DATE_TAG,Constant.MENU_MESSAGE));
                break;
            case Constant.MENU_SHOP:
                startActivity(new Intent(this, MenuActivity.class).putExtra(Constant.MENU_DATE_TAG,Constant.MENU_SHOP));
                break;
            case Constant.MENU_USER_SETTINGS:
                startActivity(new Intent(this, MenuActivity.class).putExtra(Constant.MENU_DATE_TAG,Constant.MENU_USER_SETTINGS));
                break;
            case Constant.MENU_APP_SETTINGS:
                startActivity(new Intent(this, MenuActivity.class).putExtra(Constant.MENU_DATE_TAG,Constant.MENU_APP_SETTINGS));
                break;
        }
    }
}
