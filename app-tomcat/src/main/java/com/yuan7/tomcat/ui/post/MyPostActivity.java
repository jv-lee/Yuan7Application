package com.yuan7.tomcat.ui.post;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    @BindView(R.id.rg_appbar_toolbar_tab)
    RadioGroup tabTitle;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_userIcon)
    ImageView ivUserIcon;
    @BindView(R.id.tv_userName)
    TextView tvUserName;
    @BindView(R.id.tv_levelNum)
    TextView tvLevelNum;
    @BindView(R.id.tv_levelName)
    TextView tvLevelName;
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

        GlideImageLoader.loadCircleCrop(SPUtil.get(UserParams.USER_ICON_URL, ""), ivUserIcon);
        tvUserName.setText((String) SPUtil.get(UserParams.USER_NAME, ""));
        tvLevelNum.setText("LV:" + SPUtil.get(UserParams.USER_LEVEL, 0));
        tvLevelName.setText((String) SPUtil.get(UserParams.USER_LEVEL_NAME, ""));
        tvTitle.setText("我的发帖");

        for (int i = 0; i < 2; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("content", titles[i]);
            fragments[i].setArguments(bundle);
        }

        ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        vpContainer.setAdapter(new UiPagerAdapter(mFragmentManager, fragments, titles));
        vpContainer.setOffscreenPageLimit(fragments.length - 1);

        vpContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        ((RadioButton) tabTitle.findViewById(R.id.rb_post)).setChecked(true);
                        break;
                    case 1:
                        ((RadioButton) tabTitle.findViewById(R.id.rb_reply)).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabTitle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_post:
                        vpContainer.setCurrentItem(0);
                        break;
                    case R.id.rb_reply:
                        vpContainer.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }
}
