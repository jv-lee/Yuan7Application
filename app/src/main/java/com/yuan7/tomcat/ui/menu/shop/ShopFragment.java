package com.yuan7.tomcat.ui.menu.shop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import com.yuan7.tomcat.adapter.ShopAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.ProdouctEntity;
import com.yuan7.tomcat.entity.ShopBannerEntity;
import com.yuan7.tomcat.interfaces.TitleBarListener;
import com.yuan7.tomcat.ui.menu.shop.inject.DaggerShopComponent;
import com.yuan7.tomcat.ui.menu.shop.inject.ShopModule;
import com.yuan7.tomcat.widget.banner.MZBannerView;
import com.yuan7.tomcat.widget.banner.holder.MZHolderCreator;
import com.yuan7.tomcat.widget.banner.holder.MZViewHolder;
import com.yuan7.tomcat.widget.banner.holder.ShopBannerViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseFragment<ShopContract.Presenter> implements ShopContract.View {

    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;

    private ShopAdapter dataAdapter;
    private int page = 1;

    private View headView;
    private MZBannerView<ShopBannerEntity> banner;
    private List<ShopBannerEntity> banners;

    private TitleBarListener listener;

    public ShopFragment(TitleBarListener listener) {
        this.listener = listener;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerShopComponent.builder()
                .appComponent(appComponent)
                .shopModule(new ShopModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    protected void bindData() {
        listener.setTitleText(getString(R.string.menu_item_shop));

        headView = LayoutInflater.from(mActivity).inflate(R.layout.layout_hot_head, null, false);
        banner = (MZBannerView<ShopBannerEntity>) headView.findViewById(R.id.banner);
        banner.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        banner.setDelayedTime(3000);
        banner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                if (banners != null && banners.size() > 0) {
                    Toast.makeText(mActivity, banners.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        dataAdapter = new ShopAdapter(new ArrayList<ProdouctEntity>());
        dataAdapter.addHeaderView(headView);
        dataAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        dataAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.bindShopData(page);
            }
        });

        rvContainer.setLayoutManager(new GridLayoutManager(mActivity, 2));
        rvContainer.setAdapter(dataAdapter);
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
                page = 1;
                mPresenter.bindBannerData();
                mPresenter.bindShopData(page);
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
    public void bindBannerData(List<ShopBannerEntity> result, List<String> images) {
        if (result != null) {
            banners = result;
            banner.setPages(result, new MZHolderCreator() {
                @Override
                public MZViewHolder createViewHolder() {
                    return new ShopBannerViewHolder();
                }
            });
            banner.start();
        }
    }

    @Override
    public void bindShopData(int pageNo, ResultEntity<ProdouctEntity> result) {
        if (pageNo == 1 && result.getObj().getRows().size() == 0) {
            refreshLayout.finishRefreshing();
            return;
        }
        if (pageNo > result.getObj().getCountPage()) {
            dataAdapter.loadMoreEnd();
            return;
        }
        if (pageNo == 1) {
            dataAdapter.getData().clear();
            dataAdapter.notifyDataSetChanged();
        }
        dataAdapter.getData().addAll(result.getObj().getRows());
        dataAdapter.notifyDataSetChanged();
        page++;
        refreshLayout.finishRefreshing();
        dataAdapter.loadMoreComplete();
    }


    @Override
    public void bindDataEvent(int code, String Shop) {

    }
}
