package com.yuan7.tomcat.ui.main;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.yuan7.tomcat.Config;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.ui.ToolbarControlInterface;
import com.yuan7.tomcat.ui.main.home.HomeFragment;
import com.yuan7.tomcat.ui.main.raiders.RaidersFragment;
import com.yuan7.tomcat.ui.main.recommend.RecommendFragment;
import com.yuan7.tomcat.ui.main.video.VideoFragment;
import com.yuan7.tomcat.widget.NoScrollViewPager;


import butterknife.BindView;

public class MainActivity extends BaseActivity implements ToolbarControlInterface {

    @BindView(R.id.navigationBar)
    BottomNavigationBar navigationBar;
    @BindView(R.id.vp_container)
    NoScrollViewPager vpContainer;
    @BindView(R.id.toolbar)
    LinearLayout toolbar;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private Fragment[] fragments;
    private Fragment[] openFragments = {
            new HomeFragment(this), new VideoFragment(this), new RaidersFragment(this), new RecommendFragment(this)
    };
    private Fragment[] closeFragments = {
            new HomeFragment(this), new VideoFragment(this), new RaidersFragment(this)};

    private BottomNavigationItem[] items;
    private BottomNavigationItem[] openItems = {
            new BottomNavigationItem(R.drawable.ic_home, "首页").setActiveColorResource(R.color.colorPrimary)
            , new BottomNavigationItem(R.drawable.ic_video, "视频").setActiveColorResource(R.color.colorPrimary)
            , new BottomNavigationItem(R.drawable.ic_raiders, "攻略").setActiveColorResource(R.color.colorPrimary)
            , new BottomNavigationItem(R.drawable.ic_recommend, "推荐").setActiveColorResource(R.color.colorPrimary)
    };
    private BottomNavigationItem[] closeItems = {
            new BottomNavigationItem(R.drawable.ic_home, "首页").setActiveColorResource(R.color.colorPrimary)
            , new BottomNavigationItem(R.drawable.ic_video, "视频").setActiveColorResource(R.color.colorPrimary)
            , new BottomNavigationItem(R.drawable.ic_raiders, "攻略").setActiveColorResource(R.color.colorPrimary)
    };

    @Override
    protected int bindRootView() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindData() {
        setSwipeBackEnable(false);

        if (Config.TAB_TAG.equals(Config.getCloseTag())) {
            items = closeItems;
            fragments = closeFragments;
        } else {
            items = openItems;
            fragments = openFragments;
        }

        vpContainer.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), fragments));
        vpContainer.setNoScroll(true);
        vpContainer.setOffscreenPageLimit(fragments.length - 1);

        for (int i = 0; i < items.length; i++) {
            navigationBar.addItem(items[i]);
        }
        navigationBar.initialise();
        navigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                vpContainer.setCurrentItem(position, false);
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }
        });
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void setToolbarVisibility(boolean flag) {
        if (flag) {
            toolbar.setVisibility(View.VISIBLE);
        } else {
            toolbar.setVisibility(View.GONE);
        }
    }

    @Override
    public void setTileText(String title) {
        tvTitle.setText(title);
    }
}
