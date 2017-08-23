package com.yuan7.tomcat.ui.main.commu.community;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.CommunityAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.entity.CommunityEntity;
import com.yuan7.tomcat.ui.main.commu.community.inject.CommunityModule;
import com.yuan7.tomcat.ui.main.commu.community.inject.DaggerCommunityComponent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityContentFragment extends BaseFragment<CommunityContract.Presenter> implements CommunityContract.View {

    private String text;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;

    private CommunityAdapter communityAdapter;
    private List<CommunityEntity> communityEntities = new ArrayList<>();

    public CommunityContentFragment() {
    }


    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerCommunityComponent.builder()
                .appComponent(appComponent)
                .communityModule(new CommunityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_conmmunity_content, container, false);
    }

    @Override
    protected void bindData() {
        text = getArguments().getString("type");
        communityAdapter = new CommunityAdapter(communityEntities);
        communityAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.bindCommunityData(2);
            }
        });

        rvContainer.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContainer.setAdapter(communityAdapter);
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
                mPresenter.bindCommunityData(1);
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
    public void bindCommunityData(List<CommunityEntity> result) {
        communityAdapter.getData().addAll(result);
        communityAdapter.notifyDataSetChanged();
        refreshLayout.finishRefreshing();
        communityAdapter.loadMoreComplete();
    }

    @Override
    public void bindDataEvent(int code, String message) {

    }
}
