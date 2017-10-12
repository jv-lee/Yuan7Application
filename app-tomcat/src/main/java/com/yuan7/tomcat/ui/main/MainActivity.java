package com.yuan7.tomcat.ui.main;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.video.lib.VideoPlayer;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.entity.ResultBeanEntity;
import com.yuan7.tomcat.entity.impl.SettingsUserEntity;
import com.yuan7.tomcat.entity.impl.UserMessage;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.helper.AHelper;
import com.yuan7.tomcat.rx.EventBase;
import com.yuan7.tomcat.rx.RxBus;
import com.yuan7.tomcat.ui.main.inject.DaggerMainComponent;
import com.yuan7.tomcat.ui.main.inject.MainModule;
import com.yuan7.tomcat.ui.menu.MenuActivity;
import com.yuan7.tomcat.ui.post.MyPostActivity;
import com.yuan7.tomcat.ui.main.comm.CommuFragment;
import com.yuan7.tomcat.ui.main.info.InfoFragment;
import com.yuan7.tomcat.ui.main.start.StartFragment;
import com.yuan7.tomcat.ui.send.SendActivity;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.utils.NetworkUtil;
import com.yuan7.tomcat.utils.SPUtil;
import com.yuan7.tomcat.widget.NoScrollViewPager;
import com.yuan7.tomcat.widget.roundImageView.RoundedImageView;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {

    @BindView(R.id.main_container)
    NoScrollViewPager mainContainer;
    @BindView(R.id.radio_nav_group)
    RadioGroup mainNav;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.iv_fab)
    ImageView ivFab;

    //侧滑菜单项
    @BindView(R.id.item_friend)
    RelativeLayout itemFriend;
    @BindView(R.id.item_post)
    RelativeLayout itemPost;
    @BindView(R.id.item_message)
    RelativeLayout itemMessage;
    @BindView(R.id.item_shop)
    RelativeLayout itemShop;
    @BindView(R.id.item_record)
    RelativeLayout itemRecord;
    @BindView(R.id.item_userSettings)
    RelativeLayout itemUserSettings;
    @BindView(R.id.item_appSettings)
    RelativeLayout itemAppSettings;
    @BindView(R.id.item_code)
    RelativeLayout itemCode;
    @BindView(R.id.item_ad)
    RelativeLayout itemAd;

    @BindView(R.id.riv_userIcon)
    RoundedImageView rivUserIcon;
    @BindView(R.id.tv_userName)
    TextView tvUserName;
    @BindView(R.id.tv_levelNum)
    TextView tvLevelNum;
    @BindView(R.id.tv_levelName)
    TextView tvLevelName;

    @BindView(R.id.tv_friendNum)
    TextView tvFriendNum;
    @BindView(R.id.tv_postNum)
    TextView tvPostNum;
    @BindView(R.id.tv_messagedNum)
    TextView tvMessageNum;
    @BindView(R.id.iv_point)
    ImageView ivPoint;

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

        SPUtil.save(UserParams.LOGIN_STATUS, true); //进入登陆状态

        mainContainer.setAdapter(new UiPagerAdapter(mFragmentManager, fragments));
        mainContainer.setNoScroll(true);
        mainContainer.setOffscreenPageLimit(fragments.length - 1);

        mainNav.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        mainContainer.setCurrentItem(0, false);
                        break;
                    case R.id.rb_community:
                        mainContainer.setCurrentItem(1, false);
                        break;
                    case R.id.rb_start:
                        AHelper.toEvent(MainActivity.this, "T_1009");
                        mainContainer.setCurrentItem(2, false);
                        break;
                }
            }
        });

        observable = RxBus.getInstance().register(this);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EventBase>() {
                    @Override
                    public void accept(@NonNull EventBase eventBase) throws Exception {
                        if ((int) eventBase.getOption() == Constant.RX_BUS_START_FRIEND) {
                            if (mainNav != null) {
                                RadioButton radioButton = (RadioButton) mainNav.findViewById(R.id.rb_community);
                                if (radioButton != null) {
                                    radioButton.setChecked(true);
                                }
                            }

                        } else if ((int) eventBase.getOption() == Constant.RX_BUS_START_MENU) {
                            SettingsUserEntity entity = (SettingsUserEntity) eventBase.getObj();
                            if (entity != null) {
                                if (rivUserIcon != null && tvUserName != null && tvLevelNum != null) {
                                    GlideImageLoader.loadCircleCrop(entity.getObj().getImage(), rivUserIcon);
                                    tvUserName.setText(entity.getObj().getName());
                                    tvLevelNum.setText("LV:" + entity.getObj().getLevel());
                                }
                            }
                        } else if ((int) eventBase.getOption() == Constant.RX_BUS_START_UNLOGIN) {
                            SPUtil.save(UserParams.LOGIN_STATUS, false); //退出登陆
                            finish();
                        } else if ((int) eventBase.getOption() == Constant.RX_BUS_START_ICON) {
                            if (rivUserIcon != null) {
                                SPUtil.save(UserParams.USER_ICON_URL, (String) eventBase.getObj());
                                GlideImageLoader.loadCircleCropBg((String) eventBase.getObj(), rivUserIcon);
                            }
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


        if (NetworkUtil.isConnected(this)) {
            mPresenter.firstLogin();
            mPresenter.bindMenuData();
        } else {
            Toast.makeText(mContext, "网络未连接", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
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

    @OnClick({R.id.item_friend, R.id.item_post, R.id.item_message, R.id.item_shop, R.id.item_record, R.id.item_userSettings, R.id.item_appSettings, R.id.item_code, R.id.item_ad, R.id.iv_fab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_friend:
                mode = Constant.MENU_FRIEND;
                break;
            case R.id.item_post:
                mode = Constant.MENU_POST;
                break;
            case R.id.item_message:
                tvMessageNum.setText("(0)");
                ivPoint.setVisibility(View.INVISIBLE);
                mode = Constant.MENU_MESSAGE;
                break;
            case R.id.item_shop:
                mode = Constant.MENU_SHOP;
                break;
            case R.id.item_record:
                mode = Constant.MENU_RECORD;
                break;
            case R.id.item_userSettings:
                mode = Constant.MENU_USER_SETTINGS;
                break;
            case R.id.item_appSettings:
                mode = Constant.MENU_APP_SETTINGS;
                break;
            case R.id.item_code:
                mode = Constant.MENU_CODE;
                break;
            case R.id.item_ad:
                mode = Constant.MENU_AD;
                break;
            case R.id.iv_fab:
                AHelper.toEvent(this, "T_1006");
                startActivity(new Intent(this, SendActivity.class));
                break;
        }
        itemFlag = true;
        drawer.closeDrawer(Gravity.START);
    }

    public void startMenuItem() {
        if (!itemFlag) {
            return;
        }
        itemFlag = false;
        switch (mode) {
            case Constant.MENU_FRIEND:
                RxBus.getInstance().post(new EventBase(Constant.RX_BUS_START_FRIEND, null));
                break;
            case Constant.MENU_POST:
                startActivity(new Intent(this, MyPostActivity.class));
                break;
            case Constant.MENU_MESSAGE:
                startActivity(new Intent(this, MenuActivity.class).putExtra(Constant.MENU_DATE_TAG, Constant.MENU_MESSAGE));
                break;
            case Constant.MENU_SHOP:
                AHelper.toEvent(this, "T_1005");
                startActivity(new Intent(this, MenuActivity.class).putExtra(Constant.MENU_DATE_TAG, Constant.MENU_SHOP));
                break;
            case Constant.MENU_RECORD:
                startActivity(new Intent(this, MenuActivity.class).putExtra(Constant.MENU_DATE_TAG, Constant.MENU_RECORD));
                break;
            case Constant.MENU_USER_SETTINGS:
                startActivity(new Intent(this, MenuActivity.class).putExtra(Constant.MENU_DATE_TAG, Constant.MENU_USER_SETTINGS));
                break;
            case Constant.MENU_APP_SETTINGS:
                startActivity(new Intent(this, MenuActivity.class).putExtra(Constant.MENU_DATE_TAG, Constant.MENU_APP_SETTINGS));
                break;
            case Constant.MENU_CODE:
                startActivity(new Intent(this, MenuActivity.class).putExtra(Constant.MENU_DATE_TAG, Constant.MENU_CODE));
                break;
            case Constant.MENU_AD:
                AHelper.toEvent(this, "T_1013");
                break;
        }
    }

    @Override
    public void bindMenuData(ResultBeanEntity<UserMessage> resultBeanEntity) {
        GlideImageLoader.loadCircleCropBg(resultBeanEntity.getObj().getImage(), rivUserIcon);
        tvUserName.setText(resultBeanEntity.getObj().getName());
        tvLevelNum.setText("LV:" + resultBeanEntity.getObj().getLevel());
        tvLevelName.setText(resultBeanEntity.getObj().getLevelname());

        if (resultBeanEntity.getObj().getUnreadMsgNum() == 0) {
            ivPoint.setVisibility(View.GONE);
        }

        tvFriendNum.setText("(" + resultBeanEntity.getObj().getFriendsNum() + ")");
        tvPostNum.setText("(" + resultBeanEntity.getObj().getNewsNum() + ")");
        tvMessageNum.setText("(" + resultBeanEntity.getObj().getUnreadMsgNum() + ")");

        SPUtil.save(UserParams.USER_HAS_INVITECODE, resultBeanEntity.getObj().isIsinvite());
        SPUtil.save(UserParams.USER_INVITECODE, resultBeanEntity.getObj().getInvitecode());
        SPUtil.save(UserParams.USER_WRITE_INVITECODE, resultBeanEntity.getObj().getWritecode());

    }
}
