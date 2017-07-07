package com.yuan7.tomcat.ui.main.raiders;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.RaidersBean;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/5/17.
 */
@ActivityScope
public class RaidersPresenter extends BasePresenter<RaidersContract.Model, RaidersContract.View> implements RaidersContract.Presenter {

    @Inject
    public RaidersPresenter() {
    }

    @Override
    public void onDestroy() {
        mView = null;
        mModel = null;
    }

    @Override
    public void bindRaidersData(final int pageNo) {
        mModel.doGetRaiders(pageNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RaidersBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.bindDataEvent(0, e.getMessage());
                    }

                    @Override
                    public void onNext(RaidersBean raidersBean) {
                        mView.bindRaidersData(pageNo, raidersBean);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
