package com.yuan7.tomcat.ui.main.comm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.video.lib.VideoPlayer;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.rx.EventBase;
import com.yuan7.tomcat.rx.RxBus;
import com.yuan7.tomcat.ui.main.MainActivity;
import com.yuan7.tomcat.ui.main.comm.aq.AQFragment;
import com.yuan7.tomcat.ui.main.comm.community.CommunityFragment;
import com.yuan7.tomcat.ui.main.comm.friend.FriendFragment;
import com.yuan7.tomcat.ui.search.SearchActivity;
import com.yuan7.tomcat.utils.LogUtil;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/8/21.
 */

public class CommuFragment extends BaseFragment {

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

    private Observable observable;

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
        fragments = new Fragment[]{new CommunityFragment(), new AQFragment(), new FriendFragment()};
        titles = new String[]{getString(R.string.comm_tab_community), getString(R.string.comm_tab_aq), getString(R.string.comm_tab_friend)};

        observable = RxBus.getInstance().register(this);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EventBase>() {
                    @Override
                    public void accept(@NonNull EventBase eventBase) throws Exception {
                        if ((int) eventBase.getOption() == Constant.RX_BUS_START_FRIEND) {
                            if (vpContainer != null) {
                                vpContainer.setCurrentItem(2);
                            }
                        }
                    }
                });

        for (int i = 0; i < 3; i++) {
            Bundle bundle = new Bundle();
            bundle.putString(Constant.FRAGMENT_CONTENT, titles[i]);
            fragments[i].setArguments(bundle);
        }
        vpContainer.setAdapter(new UiPagerAdapter(getChildFragmentManager(), fragments, titles));
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
                VideoPlayer.releaseAllVideos();
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister(this);
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
