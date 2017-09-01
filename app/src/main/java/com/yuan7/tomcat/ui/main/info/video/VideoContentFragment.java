package com.yuan7.tomcat.ui.main.info.video;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.VideoAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.entity.VideoEntity;
import com.yuan7.tomcat.ui.main.info.video.inject.DaggerVideoComponent;
import com.yuan7.tomcat.ui.main.info.video.inject.VideoModule;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoContentFragment extends BaseFragment<VideoContract.Presenter> implements VideoContract.View {

    private String text;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;

    private VideoAdapter videoAdapter;
    private List<VideoEntity> videoEntities = new ArrayList<>();

    public VideoContentFragment() {
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerVideoComponent.builder()
                .appComponent(appComponent)
                .videoModule(new VideoModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video_content, container, false);
    }

    @Override
    protected void bindData() {
        text = getArguments().getString(Constant.FRAGMENT_TYPE);
        Toast.makeText(mActivity, text, Toast.LENGTH_SHORT).show();
        videoAdapter = new VideoAdapter(videoEntities);
        videoAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.bindVideoData(2);
            }
        });

        rvContainer.setLayoutManager(new GridLayoutManager(mActivity, 2));
        rvContainer.setAdapter(videoAdapter);
        rvContainer.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

        ProgressLayout progressLayout = new ProgressLayout(mActivity);
//        progressLayout.setColorSchemeColors(Color.parseColor("#000000"));
        refreshLayout.setHeaderView(progressLayout);
        refreshLayout.setEnableLoadmore(false);
        refreshLayout.setEnableOverScroll(false);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                mPresenter.bindVideoData(1);
            }
        });
        refreshLayout.startRefresh();
    }

    @Override
    protected void lazyLoad() {
        if (refreshLayout != null) {
            refreshLayout.startRefresh();
        }
    }

    @Override
    public void bindVideoData(List<VideoEntity> result) {
        videoAdapter.getData().addAll(result);
        videoAdapter.notifyDataSetChanged();
        refreshLayout.finishRefreshing();
        videoAdapter.loadMoreComplete();
    }

    @Override
    public void bindDataEvent(int code, String message) {

    }
}
