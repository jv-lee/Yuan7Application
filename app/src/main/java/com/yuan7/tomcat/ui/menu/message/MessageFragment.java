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
import com.yuan7.tomcat.interfaces.TitleBarListener;
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

    private Fragment[] fragments = null;
    private String[] titles = null;
    private int[] args = new int[]{Constant.TYPE_MESSAGE_FIND_THIS, Constant.TYPE_MESSAGE_INPUT_THIS, Constant.TYPE_MESSAGE_NICE_THIS};

    private TitleBarListener listener;

    public MessageFragment(TitleBarListener listener) {
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
        listener.setTitleText(getString(R.string.menu_item_message));

        fragments = new Fragment[]{new MessageContentFragment(), new MessageContentFragment(), new MessageContentFragment()};
        titles = new String[]{getString(R.string.select_tab_find_me), getString(R.string.select_tab_input_me), getString(R.string.select_tab_nice_me)};

        for (int i = 0; i < 3; i++) {
            Bundle bundle = new Bundle();
            bundle.putInt(Constant.FRAGMENT_TYPE, args[i]);
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
