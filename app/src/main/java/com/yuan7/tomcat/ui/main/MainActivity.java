package com.yuan7.tomcat.ui.main;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.ui.main.community.CommunityFragment;
import com.yuan7.tomcat.ui.main.info.InfoFragment;
import com.yuan7.tomcat.ui.main.start.StartFragment;
import com.yuan7.tomcat.widget.BottomNavigationViewEx;
import com.yuan7.tomcat.widget.NoScrollViewPager;
import com.yuan7.tomcat.widget.SwipeMenu;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_container)
    NoScrollViewPager mainContainer;
    @BindView(R.id.main_nav)
    BottomNavigationViewEx mainNav;
//    @BindView(R.id.nav_view)
//    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    private Fragment[] fragments = {new InfoFragment(), new CommunityFragment(), new StartFragment()};


    @Override
    protected int bindRootView() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindData() {
        setBackEnable(false);
        setFinishFlag(false);
        backExitEnable(true);
        mainNav.enableAnimation(false);
        mainContainer.setAdapter(new UiPagerAdapter(mFragmentManager, fragments));
        mainContainer.setNoScroll(true);
        mainContainer.setOffscreenPageLimit(fragments.length - 1);
        mainNav.setupWithViewPager(mainContainer);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }
}
