package com.yuan7.tomcat.ui.menu.post.reply;

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
import com.yuan7.tomcat.adapter.ReplyAdapter;
import com.yuan7.tomcat.adapter.SendAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.entity.ReplyEntity;
import com.yuan7.tomcat.entity.SendEntity;
import com.yuan7.tomcat.rx.EventBase;
import com.yuan7.tomcat.rx.RxBus;
import com.yuan7.tomcat.ui.menu.post.reply.inject.DaggerReplyComponent;
import com.yuan7.tomcat.ui.menu.post.reply.inject.ReplyModule;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ReplyFragment extends BaseFragment<ReplyContract.Presenter> implements ReplyContract.View {

    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;

    private Observable observable;

    private ReplyAdapter replyAdapter;
    private List<ReplyEntity> replyEntities = new ArrayList<>();

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerReplyComponent.builder()
                .appComponent(appComponent)
                .replyModule(new ReplyModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reply, container, false);
    }

    @Override
    protected void bindData() {
        observable = RxBus.getInstance().register(this);

        replyAdapter = new ReplyAdapter(replyEntities);
        replyAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        replyAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.bindReplyData(2);
            }
        });

        rvContainer.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContainer.setAdapter(replyAdapter);
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
                mPresenter.bindReplyData(1);
            }
        });

        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EventBase>() {
                    @Override
                    public void accept(@NonNull EventBase eventBase) throws Exception {
                        if (refreshLayout != null) {
                            if ((int)eventBase.getOption() == Constant.RX_BUS_APPBAR_OPEN) {
                                refreshLayout.setEnableRefresh(true);
                            }else{
                                refreshLayout.setEnableRefresh(false);
                            }
                        }
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
    public void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister(this);
    }

    @Override
    public void bindReplyData(List<ReplyEntity> result) {
        replyAdapter.getData().addAll(result);
        replyAdapter.notifyDataSetChanged();
        refreshLayout.finishRefreshing();
        replyAdapter.loadMoreComplete();
    }

    @Override
    public void bindDataEvent(int code, String Shop) {

    }
}
