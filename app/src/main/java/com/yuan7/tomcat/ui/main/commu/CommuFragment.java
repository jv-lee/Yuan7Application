package com.yuan7.tomcat.ui.main.commu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.ui.main.MainActivity;
import com.yuan7.tomcat.ui.main.commu.aq.AQFragment;
import com.yuan7.tomcat.ui.main.commu.community.CommunityFragment;
import com.yuan7.tomcat.ui.main.commu.friend.FriendFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/21.
 */

public class CommuFragment extends BaseFragment {

    @BindView(R.id.tab_title)
    TabLayout tabTitle;
    @BindView(R.id.vp_container)
    ViewPager vpContainer;
    @BindView(R.id.iv_left)
    ImageView ivLeft;

    private Fragment[] fragments = {new CommunityFragment(), new AQFragment(), new FriendFragment()};
    private String[] titles = {"社区", "回答", "好友"};

    public CommuFragment() {
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_commu, container, false);
    }

    @Override
    protected void bindData() {
        for (int i = 0; i < 3; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("content", titles[i]);
            fragments[i].setArguments(bundle);
        }
        vpContainer.setAdapter(new UiPagerAdapter(getChildFragmentManager(), fragments, titles));
        vpContainer.setOffscreenPageLimit(fragments.length - 1);
        tabTitle.setupWithViewPager(vpContainer);
    }

    @Override
    protected void lazyLoad() {
    }

    @OnClick(R.id.iv_left)
    public void onClick(View view) {
        ((MainActivity)getActivity()).openDrawer();
    }

}
