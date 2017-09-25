package com.yuan7.tomcat.ui.main.start;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.StartAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.bean.impl.StartEntity;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.ui.content.news.ActiveActivity;
import com.yuan7.tomcat.ui.main.MainActivity;
import com.yuan7.tomcat.ui.main.start.inject.DaggerStartComponent;
import com.yuan7.tomcat.ui.main.start.inject.StartModule;
import com.yuan7.tomcat.ui.search.SearchActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends BaseFragment<StartContract.Presenter> implements StartContract.View {

    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.iv_right)
    ImageView ivRight;

    @BindView(R.id.iv_appIcon)
    ImageView ivAppIcon;
    @BindView(R.id.btn_start)
    Button btnStart;
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;
    @BindView(R.id.tv_content)
    TextView tvContent;

    StartAdapter dataAdapter;

    public StartFragment() {
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerStartComponent.builder()
                .appComponent(appComponent)
                .startModule(new StartModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    protected void bindData() {
        dataAdapter = new StartAdapter(new ArrayList<String>());
        rvContainer.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
        rvContainer.setAdapter(dataAdapter);
        mPresenter.bindStartData();
    }

    @Override
    protected void lazyLoad() {
        Log.i(TAG, "lazyLoad()");
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

    @Override
    public void bindStartData(StartEntity resultEntity) {
        List<String> list = Arrays.asList(resultEntity.getObj().getPromotedApp().getImages().split("，"));
        dataAdapter.getData().addAll(list);
        dataAdapter.notifyDataSetChanged();
        GlideImageLoader.loadImage(resultEntity.getObj().getPromotedApp().getBannerimage(), ivAppIcon);
        tvContent.setText(resultEntity.getObj().getPromotedApp().getContent());

        if (resultEntity.getObj().getAppConfig().getActivity()) {
            startActivity(new Intent(mActivity, ActiveActivity.class));
//            mActivity.overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
        }

    }

    @Override
    public void bindDataEvent(int code, String message) {

    }
}
