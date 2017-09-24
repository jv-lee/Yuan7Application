package com.yuan7.tomcat.ui.main.start;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.StartEntity;
import com.yuan7.tomcat.utils.LogUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by Administrator on 2017/9/15.
 */
@ActivityScope
public class StartPresenter extends BasePresenter<StartContract.Model, StartContract.View> implements StartContract.Presenter {

    @Inject
    public StartPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindStartData() {
        mModel.doPostStart()
                .subscribe(new Observer<StartEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(StartEntity resultEntity) {
                        mView.bindStartData(resultEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.getStackTraceString(e);
                        LogUtil.e(e.getMessage());
                        mView.bindDataEvent(0, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
