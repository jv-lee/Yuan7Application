package com.yuan7.tomcat.ui.main.start;


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
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.StartEntity;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.ui.main.MainActivity;
import com.yuan7.tomcat.ui.main.start.inject.DaggerStartComponent;
import com.yuan7.tomcat.ui.main.start.inject.StartModule;

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
        rvContainer.setLayoutManager(new LinearLayoutManager(mActivity,LinearLayoutManager.HORIZONTAL,false));
        rvContainer.setAdapter(dataAdapter);
    }

    @Override
    protected void lazyLoad() {
        mPresenter.bindStartData();
        Log.i(TAG, "lazyLoad()");
    }

    @OnClick(R.id.iv_left)
    public void onClick(View view) {
        ((MainActivity) getActivity()).openDrawer();
    }

    @Override
    public void bindStartData(StartEntity resultEntity) {
        List<String> list = Arrays.asList(resultEntity.getObj().getPromotedApp().getImages().split(","));
        List<String> list2 = Arrays.asList(new String[]{"", "", ""});
        dataAdapter.getData().addAll(list2);
        dataAdapter.notifyDataSetChanged();
        GlideImageLoader.loadImage(resultEntity.getObj().getPromotedApp().getBannerimage(), ivAppIcon);
//        tvContent.setText(resultEntity.getObj().getPromotedApp().getContent());
    }

    @Override
    public void bindDataEvent(int code, String message) {

    }
}
