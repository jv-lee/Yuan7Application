package com.yuan7.tomcat.ui.menu.message;


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
import com.yuan7.tomcat.adapter.MessageAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.bean.impl.MessageEntity;
import com.yuan7.tomcat.ui.menu.message.inject.DaggerMessageComponent;
import com.yuan7.tomcat.ui.menu.message.inject.MessageModule;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageContentFragment extends BaseFragment<MessageContract.Presenter> implements MessageContract.View {


    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;

    private int type = 0;
    private int page = 1;

    private MessageAdapter dataAdapter;

    public MessageContentFragment() {
    }


    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerMessageComponent.builder()
                .appComponent(appComponent)
                .messageModule(new MessageModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message_content, container, false);
    }

    @Override
    protected void bindData() {
        type = getArguments().getInt(Constant.FRAGMENT_TYPE);
        dataAdapter = new MessageAdapter(new ArrayList<MessageEntity>());
        dataAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        dataAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.bindMessageData(page, type);
            }
        });

        rvContainer.setLayoutManager(new LinearLayoutManager(mActivity));
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
                mPresenter.bindMessageData(page, type);
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
    public void bindMessageData(int pageNo, ResultDataEntity<MessageEntity> result) {
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
    public void bindDataEvent(int code, String message) {

    }
}
