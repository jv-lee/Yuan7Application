package com.yuan7.tomcat.ui.main.info;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.yuan7.tomcat.utils.LogUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends BaseFragment {

    @BindView(R.id.tab_title)
    TabLayout tabTitle;
    @BindView(R.id.vp_container)
    ViewPager vpContainer;
    @BindView(R.id.iv_left)
    ImageView ivLeft;

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

        vpContainer.setAdapter(new UiPagerAdapter(getChildFragmentManager(), fragments, titles));
        vpContainer.setOffscreenPageLimit(fragments.length - 1);
        tabTitle.setupWithViewPager(vpContainer);
    }

    @Override
    protected void lazyLoad() {
        LogUtil.i(TAG+":lazyLoad()");
    }

    @OnClick(R.id.iv_left)
    public void onClick(View view) {
        ((MainActivity) getActivity()).openDrawer();
    }

}
