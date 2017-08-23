package com.yuan7.tomcat.ui.main.info.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.yuan7.tomcat.adapter.NewsAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.entity.NewsEntity;
import com.yuan7.tomcat.ui.main.info.news.inject.DaggerNewsComponent;
import com.yuan7.tomcat.ui.main.info.news.inject.NewsModule;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsContentFragment extends BaseFragment<NewsContract.Presenter> implements NewsContract.View {

    private String text;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;

    private NewsAdapter newsAdapter;
    private List<NewsEntity> newsEntities = new ArrayList<>();

    public NewsContentFragment() {
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerNewsComponent.builder()
                .appComponent(appComponent)
                .newsModule(new NewsModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_content, container, false);
    }

    @Override
    protected void bindData() {
        text = getArguments().getString("type");
        newsAdapter = new NewsAdapter(newsEntities);
        newsAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.bindNewsData(2);
            }
        });

        rvContainer.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContainer.setAdapter(newsAdapter);
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
                mPresenter.bindNewsData(1);
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
    public void bindNewsData(List<NewsEntity> result) {
        newsAdapter.getData().addAll(result);
        newsAdapter.notifyDataSetChanged();
        refreshLayout.finishRefreshing();
        newsAdapter.loadMoreComplete();
    }

    @Override
    public void bindDataEvent(int code, String message) {

    }
}
