package com.yuan7.tomcat.ui.main.recommend;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import com.yuan7.tomcat.bean.impl.RecommendBean;
import com.yuan7.tomcat.ui.ToolbarControlInterface;
import com.yuan7.tomcat.ui.main.home.adapter.NewsAdapter;
import com.yuan7.tomcat.ui.main.recommend.adapter.RecommendAdapter;
import com.yuan7.tomcat.ui.main.recommend.inject.DaggerRecommendComponent;
import com.yuan7.tomcat.ui.main.recommend.inject.RecommendModule;
import com.yuan7.tomcat.utils.Helper;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/5/17.
 */

public class RecommendFragment extends BaseFragment<RecommendContract.Presenter> implements RecommendContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_container)
    RecyclerView rvContainer;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;

    private RecommendAdapter adapter;

    private ToolbarControlInterface mainControlInterface;

    public RecommendFragment(ToolbarControlInterface mainControlInterface) {
        this.mainControlInterface = mainControlInterface;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerRecommendComponent.builder()
                .appComponent(appComponent)
                .recommendModule(new RecommendModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommend, null, false);
    }

    @Override
    protected void bindData() {
        adapter = new RecommendAdapter(new ArrayList<RecommendBean.ResultBean>());
        adapter.setOnLoadMoreListener(this);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);

        rvContainer.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContainer.setAdapter(adapter);
        rvContainer.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.i(TAG, ((RecommendAdapter) adapter).getData().get(position).toString());
                Helper.startContentActivity(mActivity, ((RecommendAdapter) adapter).getData().get(position));
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
                Config.recommendPageNo = 1;
                mPresenter.bindRecommendData(Config.recommendPageNo);
            }
        });
    }

    @Override
    protected void lazyLoad() {
        refreshLayout.startRefresh();
        Log.i("ACG", "lazyLoad() -> recommendFragment()");
    }

    @Override
    protected void onFragmentResume() {
        super.onFragmentResume();
        mainControlInterface.setToolbarVisibility(true);
        mainControlInterface.setTileText("推荐");
    }

    @Override
    public void bindRecommendData(int pageNo, RecommendBean bean) {
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
        Config.recommendPageNo++;
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
        mPresenter.bindRecommendData(Config.recommendPageNo);
    }
}
