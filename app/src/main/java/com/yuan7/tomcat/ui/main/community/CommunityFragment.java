package com.yuan7.tomcat.ui.main.community;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.ui.main.community.content.CommunityContentFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends BaseFragment {

    @BindView(R.id.tab_title)
    TabLayout tabTitle;
    @BindView(R.id.vp_container)
    ViewPager vpContainer;

    private String[] titles = {"社区", "问答", "成员"};
    private List<Fragment> fragmentList = new ArrayList<>();


    public CommunityFragment() {
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_community, container, false);
    }

    @Override
    protected void bindData() {
        for (int i = 0; i < 3; i++) {
            CommunityContentFragment fragment = new CommunityContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("content", titles[i]);
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }
        vpContainer.setAdapter(new UiPagerAdapter(getChildFragmentManager(), fragmentList, titles));
        vpContainer.setOffscreenPageLimit(fragmentList.size() - 1);
        tabTitle.setupWithViewPager(vpContainer);
    }

    @Override
    protected void lazyLoad() {
        Log.i(TAG, "lazyLoad()");
    }

}
