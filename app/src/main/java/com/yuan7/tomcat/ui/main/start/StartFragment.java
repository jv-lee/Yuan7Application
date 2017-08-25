package com.yuan7.tomcat.ui.main.start;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends BaseFragment {

    @BindView(R.id.iv_left)
    ImageView ivLeft;

    public StartFragment() {
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void lazyLoad() {
        Log.i(TAG, "lazyLoad()");
    }

    @OnClick(R.id.iv_left)
    public void onClick(View view) {
        ((MainActivity) getActivity()).openDrawer();
    }

}