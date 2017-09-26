package com.yuan7.tomcat.ui.main;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.yuan7.tomcat.Config;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.ui.ToolbarControlInterface;
import com.yuan7.tomcat.ui.main.home.HomeFragment;
import com.yuan7.tomcat.ui.main.raiders.RaidersFragment;
import com.yuan7.tomcat.ui.main.recommend.RecommendFragment;
import com.yuan7.tomcat.ui.main.video.VideoFragment;
import com.yuan7.tomcat.widget.FloatingImageView;
import com.yuan7.tomcat.widget.NoScrollViewPager;


import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R.id.iv_gif)
    FloatingImageView ivGif;

    private Fragment[] fragments;
    private Fragment[] openFragments = {
            new HomeFragment(this), new VideoFragment(this), new RaidersFragment(this), new RecommendFragment(this)
    };
    private Fragment[] closeFragments = {
            new HomeFragment(this), new VideoFragment(this), new RaidersFragment(this)};

    private BottomNavigationItem[] items;
    private BottomNavigationItem[] openItems = {
            new BottomNavigationItem(R.drawable.ic_home, "资讯").setActiveColorResource(R.color.colorPrimary)
            , new BottomNavigationItem(R.drawable.ic_video, "视频").setActiveColorResource(R.color.colorPrimary)
            , new BottomNavigationItem(R.drawable.ic_raiders, "新闻").setActiveColorResource(R.color.colorPrimary)
            , new BottomNavigationItem(R.drawable.ic_recommend, "推荐").setActiveColorResource(R.color.colorPrimary)
    };
    private BottomNavigationItem[] closeItems = {
            new BottomNavigationItem(R.drawable.ic_home, "资讯").setActiveColorResource(R.color.colorPrimary)
            , new BottomNavigationItem(R.drawable.ic_video, "视频").setActiveColorResource(R.color.colorPrimary)
            , new BottomNavigationItem(R.drawable.ic_raiders, "新闻").setActiveColorResource(R.color.colorPrimary)
    };

    @Override
    protected int bindRootView() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindData() {
        setBackEnable(false);
        setFinishFlag(false);
        if (Config.TAB_TAG.equals(Config.getCloseTag())) {
            items = closeItems;
            fragments = closeFragments;
        } else {
            items = openItems;
            fragments = openFragments;
        }
        RequestOptions options = new RequestOptions()
                .centerCrop()
                //.placeholder(R.mipmap.ic_launcher_round)
                .error(android.R.drawable.stat_notify_error)
                .priority(Priority.HIGH)
                //.skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

        Glide.with(this)
                .load(R.drawable.anim)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .apply(options)
                //.thumbnail(Glide.with(this).load(R.mipmap.ic_launcher))
                .into(ivGif);

//        Glide.with(this).load(R.drawable.anim).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(ivGif);

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

    @OnClick(R.id.iv_gif)
    public void onclick(View view) {
        Toast.makeText(mContext, "gif", Toast.LENGTH_SHORT).show();

    }
}
