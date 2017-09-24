package com.yuan7.tomcat.ui.main.info;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.ui.main.MainActivity;
import com.yuan7.tomcat.ui.main.info.hot.HotFragment;
import com.yuan7.tomcat.ui.main.info.news.NewsFragment;
import com.yuan7.tomcat.ui.main.info.video.VideoFragment;
import com.yuan7.tomcat.ui.search.SearchActivity;
import com.yuan7.tomcat.utils.LogUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends BaseFragment {

    @BindView(R.id.rg_appbar_toolbar_tab)
    RadioGroup tabTitle;
    @BindView(R.id.vp_container)
    ViewPager vpContainer;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.iv_right)
    ImageView ivRight;

    private Fragment[] fragments = null;
    private String[] titles = null;

    public InfoFragment() {
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    protected void bindData() {
        fragments = new Fragment[]{new HotFragment(), new VideoFragment(), new NewsFragment()};
        titles = new String[]{getString(R.string.info_tab_hot), getString(R.string.info_tab_video), getString(R.string.info_tab_news)};

        for (int i = 0; i < 3; i++) {
            Bundle bundle = new Bundle();
            bundle.putString(Constant.FRAGMENT_CONTENT, titles[i]);
            fragments[i].setArguments(bundle);
        }

        vpContainer.setAdapter(new UiPagerAdapter(getChildFragmentManager(), fragments));
        vpContainer.setOffscreenPageLimit(fragments.length - 1);
        vpContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        ((RadioButton) tabTitle.findViewById(R.id.rb_hot)).setChecked(true);
                        break;
                    case 1:
                        ((RadioButton) tabTitle.findViewById(R.id.rb_video)).setChecked(true);
                        break;
                    case 2:
                        ((RadioButton) tabTitle.findViewById(R.id.rb_news)).setChecked(true);
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
                    case R.id.rb_hot:
                        vpContainer.setCurrentItem(0);
                        break;
                    case R.id.rb_video:
                        vpContainer.setCurrentItem(1);
                        break;
                    case R.id.rb_news:
                        vpContainer.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    @Override
    protected void lazyLoad() {
        LogUtil.i(TAG + ":lazyLoad()");
    }

    @OnClick({R.id.iv_left, R.id.iv_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                ((MainActivity) getActivity()).openDrawer();
                break;
            case R.id.iv_right:
                startActivity(new Intent(mActivity, SearchActivity.class));
                break;
        }
    }

}
