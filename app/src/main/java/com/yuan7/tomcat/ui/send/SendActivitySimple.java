package com.yuan7.tomcat.ui.send;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.ui.send.aq.SendAQFragment;
import com.yuan7.tomcat.ui.send.community.SendCommunityFragment;
import com.yuan7.tomcat.widget.NoScrollViewPager;

import butterknife.BindView;
import butterknife.OnClick;

public class SendActivitySimple extends BaseActivity {

    @BindView(R.id.tab_title)
    TabLayout tabTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.vp_container)
    NoScrollViewPager vpContainer;

    private Fragment[] fragments = null;
    private String[] titles = null;

    @Override
    protected int bindRootView() {
        return R.layout.activity_send_simple;
    }

    @Override
    protected void bindData() {
        fragments = new Fragment[]{new SendCommunityFragment(), new SendAQFragment()};
        titles = new String[]{getString(R.string.comm_tab_community),getString(R.string.comm_tab_aq)};

        vpContainer.setAdapter(new UiPagerAdapter(mFragmentManager, fragments));
        vpContainer.setOffscreenPageLimit(fragments.length - 1);
        vpContainer.setNoScroll(true);

        for (int i = 0;i<titles.length;i++) {
            tabTitle.addTab(tabTitle.newTab().setText(titles[i]));
        }

        tabTitle.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        vpContainer.setCurrentItem(0,false);
                        break;
                    case 1:
                        vpContainer.setCurrentItem(1,false);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }


    @OnClick({R.id.iv_left,R.id.tv_right})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_right:
                Toast.makeText(mContext, "send", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
