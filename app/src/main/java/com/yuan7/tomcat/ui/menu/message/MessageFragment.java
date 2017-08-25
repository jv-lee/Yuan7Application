package com.yuan7.tomcat.ui.menu.message;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.interfaces.MenuTitleBarListener;
import com.yuan7.tomcat.widget.NoScrollViewPager;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends BaseFragment {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp_container)
    NoScrollViewPager vpContainer;

    private Fragment[] fragments = {new MessageContentFragment(), new MessageContentFragment(), new MessageContentFragment()};
    private String[] titles = {"@我的", "评论我的", "赞我的"};

    private MenuTitleBarListener listener;

    public MessageFragment(MenuTitleBarListener listener) {
        this.listener = listener;
    }


    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    protected void bindData() {
        listener.setTitleText(Constant.MENU_TITLE_MESSAGE);
        for (int i = 0; i < 3; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("type", titles[i]);
            fragments[i].setArguments(bundle);
        }
        vpContainer.setAdapter(new UiPagerAdapter(getFragmentManager(), fragments, titles));
        vpContainer.setOffscreenPageLimit(fragments.length - 1);
        tab.setupWithViewPager(vpContainer);

    }

    @Override
    protected void lazyLoad() {

    }

}
