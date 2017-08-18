package com.yuan7.tomcat.ui.main.community.content;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;

/**
 * Created by Administrator on 2017/8/10.
 */

public class CommunityContentFragment extends BaseFragment {

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_community_content, container, false);
    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void lazyLoad() {

    }
}
