package com.yuan7.tomcat.ui.main;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultBeanEntity;
import com.yuan7.tomcat.entity.impl.UserMessage;
import com.yuan7.tomcat.utils.LogUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/9/22.
 */
@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void firstLogin() {
        mModel.doPostFirstLogin()
                .subscribe(new Consumer<ResultBeanEntity>() {
                    @Override
                    public void accept(@NonNull ResultBeanEntity resultBeanEntity) throws Exception {

                    }
                });
    }

    @Override
    public void bindMenuData() {
        mModel.doPostMenuData()
                .subscribe(new Observer<ResultBeanEntity<UserMessage>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultBeanEntity<UserMessage> resultBeanEntity) {
                        mView.bindMenuData(resultBeanEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.getStackTraceString(e);
                        LogUtil.e(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
