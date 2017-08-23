package com.yuan7.tomcat.ui.main.info.hot;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.HotAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.entity.BannerEntity;
import com.yuan7.tomcat.entity.HotEntity;
import com.yuan7.tomcat.entity.NewsEntity;
import com.yuan7.tomcat.entity.VideoEntity;
import com.yuan7.tomcat.ui.main.info.hot.inject.DaggerHotComponent;
import com.yuan7.tomcat.ui.main.info.hot.inject.HotModule;
import com.yuan7.tomcat.widget.banner.MZBannerView;
import com.yuan7.tomcat.widget.banner.holder.BannerViewHolder;
import com.yuan7.tomcat.widget.banner.holder.MZHolderCreator;
import com.yuan7.tomcat.widget.banner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseFragment<HotContract.Presenter> implements HotContract.View {

    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;

    private View headView;
    private MZBannerView<BannerEntity> banner;
    private HotAdapter hotAdapter;

    private List<BannerEntity> banners;

    public HotFragment() {

    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerHotComponent.builder()
                .appComponent(appComponent)
                .hotModule(new HotModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hot, container, false);
    }

    @Override
    protected void bindData() {
        String content = getArguments().getString("content");
        headView = LayoutInflater.from(mActivity).inflate(R.layout.layout_hot_head, null, false);
        banner = (MZBannerView<BannerEntity>) headView.findViewById(R.id.banner);
        banner.setDelayedTime(3000);
        banner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                if (banners != null && banners.size() > 0) {
                    Toast.makeText(mActivity, banners.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        hotAdapter = new HotAdapter(new ArrayList<HotEntity>());
        hotAdapter.addHeaderView(headView);
        hotAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        hotAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.bindHotData(2);
            }
        });

        rvContainer.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContainer.setAdapter(hotAdapter);
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
                mPresenter.bindBannerData();
                mPresenter.bindHotData(1);
            }
        });
    }

    @Override
    protected void lazyLoad() {
        if (refreshLayout != null) {
            refreshLayout.startRefresh();
        }

    }

    @Override
    protected void onFragmentResume() {
        super.onFragmentResume();
        Log.i("lee", "onFragmentResume");
        if (banner != null) {
            banner.start();
        }

    }

    @Override
    protected void onFragmentPause() {
        super.onFragmentPause();
        Log.i("lee", "onFragmentPause");
        if (banner != null) {
            banner.pause();
        }

    }

    @Override
    public void bindBannerData(final List<BannerEntity> result, List<String> images) {
        if (result != null) {
            banners = result;
            banner.setPages(result, new MZHolderCreator() {
                @Override
                public MZViewHolder createViewHolder() {
                    return new BannerViewHolder();
                }
            });
            banner.start();
        }
    }

    @Override
    public void bindHotData(List<HotEntity> result) {
        hotAdapter.getData().addAll(result);
        hotAdapter.notifyDataSetChanged();
        refreshLayout.finishRefreshing();
        hotAdapter.loadMoreComplete();
    }

    @Override
    public void bindDataEvent(int code, String message) {

    }
}
