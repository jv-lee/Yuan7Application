package com.yuan7.tomcat.ui.menu.post;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.interfaces.AppBarStateChangeListener;
import com.yuan7.tomcat.rx.EventBase;
import com.yuan7.tomcat.rx.RxBus;
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
    @BindView(R.id.tv_userName)
    TextView tvUserName;
    @BindView(R.id.rating_userLevel)
    RatingBar ratingUserLevel;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp_container)
    NoScrollViewPager vpContainer;

    private Fragment[] fragments = {new MyPostFragment(), new MyPostFragment(), new MyPostFragment()};
    private String[] titles = {"发帖数", "回帖数", "点赞数"};

    @Override
    protected int bindRootView() {
        return R.layout.activity_my_post;
    }

    @Override
    protected void bindData() {
        for (int i = 0; i < 3; i++) {
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
                if (state == State.EXPANDED) {
                    RxBus.getInstance().post(new EventBase(1,null));
                } else if (state == State.COLLAPSED) {
                    RxBus.getInstance().post(new EventBase(2,null));
                } else{
                    RxBus.getInstance().post(new EventBase(2,null));
                }
            }
        });
        vpContainer.setAdapter(new UiPagerAdapter(mFragmentManager,fragments,titles));
        vpContainer.setNoScroll(true);
        vpContainer.setOffscreenPageLimit(fragments.length - 1);
        tab.setupWithViewPager(vpContainer);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }
}
