package com.yuan7.tomcat.ui.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.video.lib.VideoPlayer;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.rx.EventBase;
import com.yuan7.tomcat.rx.RxBus;
import com.yuan7.tomcat.ui.menu.MenuActivity;
import com.yuan7.tomcat.ui.menu.post.PostActivity;
import com.yuan7.tomcat.ui.main.comm.CommuFragment;
import com.yuan7.tomcat.ui.main.info.InfoFragment;
import com.yuan7.tomcat.ui.main.start.StartFragment;
import com.yuan7.tomcat.ui.send.SendActivity;
import com.yuan7.tomcat.widget.BottomNavigationViewEx;
import com.yuan7.tomcat.widget.NoScrollViewPager;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_container)
    NoScrollViewPager mainContainer;
    @BindView(R.id.main_nav)
    BottomNavigationViewEx mainNav;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.fab_send)
    FloatingActionButton fabSend;

    //侧滑菜单项
    @BindView(R.id.item_friend)
    FrameLayout tvFriend;
    @BindView(R.id.item_post)
    FrameLayout tvPost;
    @BindView(R.id.item_message)
    FrameLayout tvMessage;
    @BindView(R.id.item_shop)
    FrameLayout tvShopHome;
    @BindView(R.id.item_userSettings)
    FrameLayout tvUserSettings;
    @BindView(R.id.item_appSettings)
    FrameLayout tvAppSettings;

    private Fragment[] fragments = {new InfoFragment(), new CommuFragment(), new StartFragment()};
    private String mode = "";
    private boolean itemFlag = false;

    private Observable observable;

    @Override
    protected int bindRootView() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindData() {
        setBackEnable(false);
        setFinishFlag(false);
        backExitEnable(true);

        mainContainer.setAdapter(new UiPagerAdapter(mFragmentManager, fragments));
        mainContainer.setNoScroll(true);
        mainContainer.setOffscreenPageLimit(fragments.length - 1);
        mainContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                VideoPlayer.releaseAllVideos();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mainNav.enableAnimation(false);
        mainNav.setupWithViewPager(mainContainer);

        observable = RxBus.getInstance().register(this);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EventBase>() {
                    @Override
                    public void accept(@NonNull EventBase eventBase) throws Exception {
                        if ((int) eventBase.getOption() == Constant.RX_BUS_START_FRIEND) {
                            mainNav.setCurrentItem(1);
                        }
                    }
                });

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
    protected void onPause() {
        super.onPause();
        VideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister(this);
    }

    @Override
    public void onBackPressed() {
        if (VideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
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

    @OnClick({R.id.item_friend,R.id.item_post,R.id.item_message,R.id.item_shop,R.id.item_userSettings,R.id.item_appSettings,R.id.fab_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_friend:
                mode = Constant.MENU_FRIEND;
                break;
            case R.id.item_post:
                mode = Constant.MENU_POST;
                break;
            case R.id.item_message:
                mode = Constant.MENU_MESSAGE;
                break;
            case R.id.item_shop:
                mode = Constant.MENU_SHOP;
                break;
            case R.id.item_userSettings:
                mode = Constant.MENU_USER_SETTINGS;
                break;
            case R.id.item_appSettings:
                mode = Constant.MENU_APP_SETTINGS;
                break;
            case R.id.fab_send:
                startActivity(new Intent(this, SendActivity.class));
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
                RxBus.getInstance().post(new EventBase(Constant.RX_BUS_START_FRIEND,null));
                break;
            case Constant.MENU_POST:
                startActivity(new Intent(this,PostActivity.class));
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
