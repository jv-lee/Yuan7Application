package com.yuan7.tomcat.ui.main.comm.friend;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.FriendAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.FriendEntity;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.ui.main.comm.friend.inject.DaggerFriendComponent;
import com.yuan7.tomcat.ui.main.comm.friend.inject.FriendModule;
import com.yuan7.tomcat.ui.post.friend.FriendActivity;
import com.yuan7.tomcat.utils.IntentUtil;
import com.yuan7.tomcat.utils.SizeUtil;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendContentFragment extends BaseFragment<FriendContract.Presenter> implements FriendContract.View {

    private int type;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;

    private FriendAdapter dataAdapter;
    private int page = 1;

    public FriendContentFragment() {
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerFriendComponent.builder()
                .appComponent(appComponent)
                .friendModule(new FriendModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friend_content, container, false);
    }

    @Override
    protected void bindData() {
        type = getArguments().getInt(Constant.FRAGMENT_TYPE);
        dataAdapter = new FriendAdapter(new ArrayList<FriendEntity>());
        dataAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        View view = new View(mActivity);
        view.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, SizeUtil.dp2px(mActivity, 36)));
        dataAdapter.addHeaderView(view);
        dataAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                FriendEntity contentEntity = ((FriendAdapter) adapter).getData().get(position);
                IntentUtil.setParamsIntoActivity(mActivity, FriendActivity.class, IntentUtil.getParamsMap(contentEntity));
            }
        });
        dataAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.bindFriendData(page, type);
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
                mPresenter.bindFriendData(page, type);
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
    public void bindFriendData(int pageNo, ResultDataEntity<FriendEntity> result) {
        if (pageNo == 1 && result.getObj().getRows().size() == 0) {
            refreshLayout.finishRefreshing();
            return;
        }
        if (pageNo > 1) {
            dataAdapter.loadMoreEnd();
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
    public void bindDataEvent(int code, String message) {

    }
}
