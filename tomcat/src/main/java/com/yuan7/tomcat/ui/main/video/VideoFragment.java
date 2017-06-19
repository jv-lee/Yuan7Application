package com.yuan7.tomcat.ui.main.video;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.yuan7.tomcat.Config;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.bean.ResultBean;
import com.yuan7.tomcat.bean.impl.VideoBean;
import com.yuan7.tomcat.ui.ToolbarControlInterface;
import com.yuan7.tomcat.ui.main.video.adapter.VideoAdapter;
import com.yuan7.tomcat.ui.main.video.inject.DaggerVideoComponent;
import com.yuan7.tomcat.ui.main.video.inject.VideoModule;
import com.yuan7.tomcat.utils.Helper;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/17.
 */
@SuppressLint("ValidFragment")
public class VideoFragment extends BaseFragment<VideoContract.Presenter> implements VideoContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_container)
    RecyclerView rvContainer;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;

    private VideoAdapter adapter;

    private ToolbarControlInterface mainControlInterface;

    public VideoFragment(ToolbarControlInterface mainControlInterface) {
        this.mainControlInterface = mainControlInterface;
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
        return inflater.inflate(R.layout.fragment_video, null, false);
    }

    @Override
    protected void bindData() {
        adapter = new VideoAdapter(new ArrayList<ResultBean>());
        adapter.setOnLoadMoreListener(this);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);

        rvContainer.setLayoutManager(new GridLayoutManager(mActivity, 2));
        rvContainer.setAdapter(adapter);
        rvContainer.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.i(TAG, ((VideoAdapter) adapter).getData().get(position).toString());
                Helper.startContentActivity(mActivity, ((VideoAdapter) adapter).getData().get(position));
            }
        });

        ProgressLayout progressLayout = new ProgressLayout(mActivity);
        progressLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        refreshLayout.setHeaderView(progressLayout);
        refreshLayout.setEnableLoadmore(false);
        refreshLayout.setEnableOverScroll(false);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                Config.videoPageNo = 1;
                mPresenter.bindVideoData(Config.videoPageNo);
            }
        });
    }

    @Override
    protected void lazyLoad() {
        refreshLayout.startRefresh();
        Log.i("ACG", "lazyLoad() -> videoFragment()");
    }

    @Override
    protected void onFragmentResume() {
        super.onFragmentResume();
        if (mainControlInterface != null) {
            mainControlInterface.setToolbarVisibility(true);
            mainControlInterface.setTileText("视频");
        }
    }

    @Override
    public void bindVideoData(int pageNo, VideoBean bean) {
        if (pageNo > bean.getPageCount()) {
            adapter.loadMoreEnd();
            return;
        }
        if (pageNo == 1) {
            adapter.getData().clear();
            adapter.notifyDataSetChanged();
        }
        adapter.getData().addAll(bean.getResult());
        adapter.notifyDataSetChanged();
        Config.videoPageNo++;
        refreshLayout.finishRefreshing();
        adapter.loadMoreComplete();
    }

    @Override
    public void bindDataEvent(int eventCode, String message) {
        refreshLayout.finishRefreshing();
        adapter.loadMoreComplete();
        Toast.makeText(mActivity, "code:" + eventCode + "; message:" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.bindVideoData(Config.videoPageNo);
    }
}
