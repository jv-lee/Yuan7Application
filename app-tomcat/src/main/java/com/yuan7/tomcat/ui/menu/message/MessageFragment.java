package com.yuan7.tomcat.ui.menu.message;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.interfaces.TitleBarListener;
import com.yuan7.tomcat.utils.SPUtil;
import com.yuan7.tomcat.widget.NoScrollViewPager;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends BaseFragment {

    @BindView(R.id.rg_appbar_toolbar_tab)
    RadioGroup tabTitle;
    @BindView(R.id.vp_container)
    NoScrollViewPager vpContainer;
    @BindView(R.id.iv_userIcon)
    ImageView ivUserIcon;
    @BindView(R.id.tv_userName)
    TextView tvUsername;
    @BindView(R.id.tv_levelNum)
    TextView tvLevelNum;
    @BindView(R.id.tv_levelName)
    TextView tvLevelName;

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

        GlideImageLoader.loadCircleCropBg(SPUtil.get(UserParams.USER_ICON_URL, ""), ivUserIcon);
        tvUsername.setText((String) SPUtil.get(UserParams.USER_NAME, ""));
        tvLevelNum.setText("LV" + SPUtil.get(UserParams.USER_LEVEL, 0));
        tvLevelName.setText((String) SPUtil.get(UserParams.USER_LEVEL_NAME, ""));

        fragments = new Fragment[]{new MessageContentFragment(), new MessageContentFragment(), new MessageContentFragment()};
        titles = new String[]{getString(R.string.select_tab_find_me), getString(R.string.select_tab_input_me), getString(R.string.select_tab_nice_me)};

        for (int i = 0; i < 3; i++) {
            Bundle bundle = new Bundle();
            bundle.putInt(Constant.FRAGMENT_TYPE, args[i]);
            fragments[i].setArguments(bundle);
        }
        vpContainer.setAdapter(new UiPagerAdapter(getFragmentManager(), fragments, titles));
        vpContainer.setOffscreenPageLimit(fragments.length - 1);

        vpContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        ((RadioButton) tabTitle.findViewById(R.id.rb_me)).setChecked(true);
                        break;
                    case 1:
                        ((RadioButton) tabTitle.findViewById(R.id.rb_input)).setChecked(true);
                        break;
                    case 2:
                        ((RadioButton) tabTitle.findViewById(R.id.rb_nice)).setChecked(true);
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
                    case R.id.rb_me:
                        vpContainer.setCurrentItem(0);
                        break;
                    case R.id.rb_input:
                        vpContainer.setCurrentItem(1);
                        break;
                    case R.id.rb_nice:
                        vpContainer.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    @Override
    protected void lazyLoad() {

    }

}
