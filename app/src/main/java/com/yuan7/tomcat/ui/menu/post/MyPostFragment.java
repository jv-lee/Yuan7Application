package com.yuan7.tomcat.ui.menu.post;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.rx.EventBase;
import com.yuan7.tomcat.rx.RxBus;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPostFragment extends BaseFragment {

    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;

    private Observable observable;

    public MyPostFragment() {
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_post, container, false);
    }

    @Override
    protected void bindData() {
        observable = RxBus.getInstance().register(this);

        ProgressLayout progressLayout = new ProgressLayout(mActivity);
//        progressLayout.setColorSchemeColors(Color.parseColor("#000000"));
        refreshLayout.setHeaderView(progressLayout);
        refreshLayout.setEnableLoadmore(false);
        refreshLayout.setEnableOverScroll(false);


        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EventBase>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EventBase eventBase) {
                        if (refreshLayout != null) {
                            if ((int)eventBase.getOption() == 1) {
                                refreshLayout.setEnableRefresh(true);
                            }else{
                                refreshLayout.setEnableRefresh(false);
                            }
                        }
                    }


                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister(this);
    }
}
