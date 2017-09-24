package com.yuan7.tomcat.ui.post;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.interfaces.AppBarStateChangeListener;
import com.yuan7.tomcat.rx.EventBase;
import com.yuan7.tomcat.rx.RxBus;
import com.yuan7.tomcat.ui.post.reply.ReplyFragment;
import com.yuan7.tomcat.ui.post.post.PostFragment;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.utils.SPUtil;
import com.yuan7.tomcat.widget.NoScrollViewPager;
import com.yuan7.tomcat.widget.roundImageView.RoundedImageView;

import butterknife.BindView;

public class MyPostActivity extends BaseActivity {

    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.riv_userIcon)
    RoundedImageView rivUserIcon;
    @BindView(R.id.riv_userIcon_close)
    RoundedImageView rivUserIconClose;
    @BindView(R.id.tv_userName)
    TextView tvUserName;
    @BindView(R.id.tv_levelNum)
    TextView tvLevelNum;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp_container)
    NoScrollViewPager vpContainer;

    private Fragment[] fragments = {new PostFragment(), new ReplyFragment()};
    private String[] titles = null;

    @Override
    protected int bindRootView() {
        return R.layout.activity_my_post;
    }

    @Override
    protected void bindData() {
        titles = new String[]{getString(R.string.post_send), getString(R.string.post_reply)};

        GlideImageLoader.loadCircleCrop(SPUtil.get(UserParams.USER_ICON_URL, ""), rivUserIcon);
        tvUserName.setText((String) SPUtil.get(UserParams.USER_NAME, ""));
        tvLevelNum.setText("LV:" + SPUtil.get(UserParams.USER_LEVEL, 0));

        for (int i = 0; i < 2; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("content", titles[i]);
            fragments[i].setArguments(bundle);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        appBar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.EXPANDED) {//展开
                    rivUserIconClose.setVisibility(View.GONE);
                    RxBus.getInstance().post(new EventBase(Constant.RX_BUS_APPBAR_OPEN, null));
                } else if (state == State.COLLAPSED) {//收缩
                    rivUserIconClose.setVisibility(View.VISIBLE);
                    RxBus.getInstance().post(new EventBase(Constant.RX_BUS_APPBAR_CLOSE, null));
                } else {//滑动中
                    RxBus.getInstance().post(new EventBase(Constant.RX_BUS_APPBAR_CLOSE, null));
                }
            }
        });
        vpContainer.setAdapter(new UiPagerAdapter(mFragmentManager, fragments, titles));
//        vpContainer.setNoScroll(true);
        vpContainer.setOffscreenPageLimit(fragments.length - 1);
        tab.setupWithViewPager(vpContainer);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }
}
