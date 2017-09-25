package com.yuan7.tomcat.ui.menu.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.OrderAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.ProductOrderEntity;
import com.yuan7.tomcat.interfaces.TitleBarListener;
import com.yuan7.tomcat.ui.menu.order.inject.DaggerOrderComponent;
import com.yuan7.tomcat.ui.menu.order.inject.OrderModule;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends BaseFragment<OrderContract.Presenter> implements OrderContract.View {

    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;

    private OrderAdapter dataAdapter;

    private int page = 1;

    private TitleBarListener listener;

    public OrderFragment(TitleBarListener listener) {
        this.listener = listener;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerOrderComponent.builder()
                .appComponent(appComponent)
                .orderModule(new OrderModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    protected void bindData() {
        listener.setTitleText("我的兑换");

        dataAdapter = new OrderAdapter(new ArrayList<ProductOrderEntity>());
        dataAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        dataAdapter.setEmptyView(LayoutInflater.from(mActivity).inflate(R.layout.layout_empty_product_order, null));
        dataAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.bindOrderData(page);
            }
        });

        rvContainer.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContainer.setAdapter(dataAdapter);

        ProgressLayout progressLayout = new ProgressLayout(mActivity);
//        progressLayout.setColorSchemeColors(Color.parseColor("#000000"));
        refreshLayout.setHeaderView(progressLayout);
        refreshLayout.setEnableLoadmore(false);
        refreshLayout.setEnableOverScroll(false);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                page = 1;
                mPresenter.bindOrderData(page);
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
    public void bindOrderData(int pageNo, ResultDataEntity<ProductOrderEntity> resultEntity) {
        if (pageNo == 1 && resultEntity.getObj().getRows().size() == 0) {
            refreshLayout.finishRefreshing();
            return;
        }
        if (pageNo > resultEntity.getObj().getCountPage()) {
            dataAdapter.loadMoreEnd();
            return;
        }
        if (pageNo == 1) {
            dataAdapter.getData().clear();
            dataAdapter.notifyDataSetChanged();
        }
        dataAdapter.getData().addAll(resultEntity.getObj().getRows());
        dataAdapter.notifyDataSetChanged();
        page++;
        refreshLayout.finishRefreshing();
        dataAdapter.loadMoreComplete();
    }

    @Override
    public void bindDataEvent(int code, String message) {

    }
}
