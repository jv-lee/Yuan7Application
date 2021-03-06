package com.yuan7.tomcat.ui.main.info.hot;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.callback.SuccessCallback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.HotAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.entity.impl.ContentEntity;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.entity.impl.BannerEntity;
import com.yuan7.tomcat.ui.content.ContentActivity;
import com.yuan7.tomcat.ui.main.info.hot.inject.DaggerHotComponent;
import com.yuan7.tomcat.ui.main.info.hot.inject.HotModule;
import com.yuan7.tomcat.utils.IntentUtil;
import com.yuan7.tomcat.widget.banner.MZBannerView;
import com.yuan7.tomcat.widget.banner.holder.ContentBannerViewHolder;
import com.yuan7.tomcat.widget.banner.holder.MZHolderCreator;
import com.yuan7.tomcat.widget.banner.holder.MZViewHolder;
import com.yuan7.tomcat.widget.call.ErrorCallback;

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
    private MZBannerView<ContentEntity> banner;
    private HotAdapter dataAdapter;

    private List<ContentEntity> banners;
    private int page = 1;

    private LoadService mLoadService;

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
        View view = inflater.inflate(R.layout.fragment_hot, container, false);

//        LoadService loadService = LoadSir.getDefault().register(view, new Callback.OnReloadListener() {
//            @Override
//            public void onReload(View v) {
//
//            }
//        });
//        return loadService.getLoadLayout();
        return view;
    }

    @Override
    protected void bindData() {
        String content = getArguments().getString(Constant.FRAGMENT_CONTENT);

        headView = LayoutInflater.from(mActivity).inflate(R.layout.layout_hot_head, null, false);
        banner = (MZBannerView<ContentEntity>) headView.findViewById(R.id.banner);
        banner.setDelayedTime(3000);
        banner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                if (banners != null && banners.size() > 0) {
                    IntentUtil.setParamsIntoActivity(mActivity, ContentActivity.class, IntentUtil.getParamsMap(banners.get(position)));
                }
            }
        });

        dataAdapter = new HotAdapter(new ArrayList<ContentEntity>());
        dataAdapter.addHeaderView(headView);
        dataAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        dataAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ContentEntity contentEntity = ((HotAdapter) adapter).getData().get(position);
                if (contentEntity.getAdvertisement() != null) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    Uri content_url = Uri.parse(contentEntity.getAdvertisement().getSourceUrl());
                    intent.setData(content_url);
                    startActivity(intent);
                } else {
                    IntentUtil.setParamsIntoActivity(mActivity, ContentActivity.class, IntentUtil.getParamsMap(contentEntity));
                }

            }
        });
        dataAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.bindHotData(page);
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
                mPresenter.bindBannerData();
                mPresenter.bindHotData(page);
            }
        });
    }

    @Override
    protected void lazyLoad() {
        if (refreshLayout != null) {
            page = 1;
            mPresenter.bindBannerData();
            mPresenter.bindHotData(page);
        }
    }

    @Override
    protected void onFragmentResume() {
        super.onFragmentResume();
        if (banner != null) {
            banner.start();
        }
    }

    @Override
    protected void onFragmentPause() {
        super.onFragmentPause();
        if (banner != null) {
            banner.pause();
        }
    }

    @Override
    public void bindBannerData(BannerEntity<ContentEntity> result) {
        if (result != null) {
            banners = result.getObj();
            banner.setPages(banners, new MZHolderCreator() {
                @Override
                public MZViewHolder createViewHolder() {
                    return new ContentBannerViewHolder();
                }
            });
            banner.start();
        }
    }

    @Override
    public void bindHotData(int pageNo, ResultDataEntity<ContentEntity> result) {
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
//        mLoadService.showCallback(SuccessCallback.class);
    }

    @Override
    public void bindDataEvent(int code, String message) {
        refreshLayout.finishRefreshing();
        dataAdapter.loadMoreComplete();
//        mLoadService.showCallback(ErrorCallback.class);
        Toast.makeText(mActivity, "code:" + code + "\nmessage:" + message, Toast.LENGTH_SHORT).show();
    }

}
