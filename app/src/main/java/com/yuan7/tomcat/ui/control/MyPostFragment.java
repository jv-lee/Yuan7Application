package com.yuan7.tomcat.ui.control;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPostFragment extends BaseFragment {


    public MyPostFragment() {
        // Required empty public constructor
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_post, container, false);
    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void lazyLoad() {

    }

}
