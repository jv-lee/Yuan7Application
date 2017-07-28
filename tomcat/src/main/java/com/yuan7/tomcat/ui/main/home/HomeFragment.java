package com.yuan7.tomcat.ui.main.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.jv.bannerlib.Banner;
import com.jv.bannerlib.BannerConfig;
import com.jv.bannerlib.listener.OnBannerListener;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.yuan7.tomcat.Config;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.bean.ResultBean;
import com.yuan7.tomcat.bean.impl.NewsBean;
import com.yuan7.tomcat.ui.main.home.adapter.NewsAdapter;
import com.yuan7.tomcat.ui.main.home.inject.DaggerHomeComponent;
import com.yuan7.tomcat.ui.main.home.inject.HomeModule;
import com.yuan7.tomcat.ui.ToolbarControlInterface;
import com.yuan7.tomcat.utils.GlideImageLoader;
import com.yuan7.tomcat.utils.Helper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.jv.bannerlib.BannerConfig.CIRCLE_INDICATOR;

/**
 * Created by Administrator on 2017/5/17.
 */

@SuppressLint("ValidFragment")
public class HomeFragment extends BaseFragment<HomeContract.Presenter> implements HomeContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_container)
    RecyclerView rvContainer;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.tv_errorMessage)
    TextView tvErrorMessage;


    /**
     * 首页的头布局
     * 及子view
     */
    private View headView;
    private Banner banner;
    private ImageView ivHome1, ivHome2;

    private NewsAdapter adapter;

    private ToolbarControlInterface mainControlInterface;

    public HomeFragment(ToolbarControlInterface mainControlInterface) {
        this.mainControlInterface = mainControlInterface;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerHomeComponent.builder()
                .appComponent(appComponent)
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null, false);
    }

    @Override
    protected void bindData() {
        headView = LayoutInflater.from(mActivity).inflate(R.layout.layout_home_head, null, false);
        banner = (Banner) headView.findViewById(R.id.banner);
        ivHome1 = (ImageView) headView.findViewById(R.id.iv_homePic1);
        ivHome2 = (ImageView) headView.findViewById(R.id.iv_homePic2);

        adapter = new NewsAdapter(new ArrayList<ResultBean>());
        adapter.setOnLoadMoreListener(this);
        adapter.addHeaderView(headView);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);

        rvContainer.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContainer.setAdapter(adapter);
        rvContainer.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.i(TAG, ((NewsAdapter) adapter).getData().get(position).toString());
                Helper.startContentActivity(mActivity, ((NewsAdapter) adapter).getData().get(position));
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
                Config.homePageNo = 1;
                mPresenter.bindBannerData();
                mPresenter.bindPropagateData();
                mPresenter.bindNewsData(Config.homePageNo);
            }
        });

    }

    @Override
    protected void lazyLoad() {
        refreshLayout.startRefresh();
    }

    @Override
    protected void onFragmentResume() {
        super.onFragmentResume();
        mainControlInterface.setToolbarVisibility(false);
        mainControlInterface.setTileText("主页");
        Log.i(TAG, "onFragmentResume()");
//        if (banner != null && banner.hasStart() == false) {
//            banner.start();
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (banner != null && banner.hasStart() == false) {
//            banner.start();
//        }
    }

    @Override
    protected void onFragmentPause() {
        super.onFragmentPause();
        Log.i(TAG, "onFragmentPause()");
//        if (banner != null && banner.hasStart()) {
//            banner.stopAutoPlay();
//        }
    }

    @Override
    public void onPause() {
        super.onPause();
//        if (banner != null && banner.hasStart()) {
//            banner.stopAutoPlay();
//        }
    }

    @Override
    public void bindBannerData(final List<ResultBean> result, List<String> images) {
        if (result != null) {
            if (banner.getImageUrls().size() == 0) {
                banner.setIndicatorGravity(BannerConfig.CENTER)
                        .setImages(images)
                        .setImageLoader(new GlideImageLoader())
                        .setBannerStyle(CIRCLE_INDICATOR)
                        .setDelayTime(5000)
                        .start();
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Log.i(TAG, result.get(position).toString());
                        Helper.startContentActivity(mActivity, result.get(position));
                    }
                });
            } else {
                banner.update(images);
            }
        }
    }

    @Override
    public void bindPropagateData(final List<ResultBean> result) {
        if (result != null) {
            if (result.size() > 0) {
                GlideImageLoader.loadImage(mActivity, ServiceModule.BASE_URL + result.get(0).getImgUrl(), ivHome1);
                ivHome1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Helper.startContentActivity(mActivity, result.get(0));
                    }
                });
            }
            if (result.size() > 1) {
                GlideImageLoader.loadImage(mActivity, ServiceModule.BASE_URL + result.get(1).getImgUrl(), ivHome2);
                ivHome2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Helper.startContentActivity(mActivity, result.get(1));
                    }
                });
            }
        }
    }

    @Override
    public void bindNewsData(final int pageNo, final NewsBean newsBean) {
        if (pageNo > newsBean.getPageCount()) {
            adapter.loadMoreEnd();
            return;
        }
        if (pageNo == 1) {
            adapter.getData().clear();
            adapter.notifyDataSetChanged();
        }
        adapter.getData().addAll(newsBean.getResult());
        adapter.notifyDataSetChanged();
        Config.homePageNo++;
        refreshLayout.finishRefreshing();
        adapter.loadMoreComplete();
        rvContainer.setVisibility(View.VISIBLE);
        tvErrorMessage.setVisibility(View.GONE);
    }

    @Override
    public void bindDataEvent(int failCode, String message) {
        refreshLayout.finishRefreshing();
        if (adapter.getData().size() > 0) {
            adapter.loadMoreFail();
            rvContainer.setVisibility(View.VISIBLE);
            tvErrorMessage.setVisibility(View.GONE);
        } else {
            adapter.loadMoreComplete();
            rvContainer.setVisibility(View.GONE);
            tvErrorMessage.setVisibility(View.VISIBLE);
        }
        Toast.makeText(mActivity, "code:" + failCode + "; message:" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.bindNewsData(Config.homePageNo);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
