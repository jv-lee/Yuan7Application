package com.yuan7.tomcat.ui.menu.code;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultBeanEntity;
import com.yuan7.tomcat.entity.impl.UserEntity;
import com.yuan7.tomcat.utils.LogUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/9/22.
 */
@ActivityScope
public class CodePresenter extends BasePresenter<CodeContract.Model, CodeContract.View> implements CodeContract.Presenter {

    @Inject
    public CodePresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindCodeData() {
        mModel.doPostCodeList()
                .subscribe(new Observer<ResultBeanEntity<List<UserEntity>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultBeanEntity<List<UserEntity>> userEntityResultBeanEntity) {
                        mView.bindCodeData(userEntityResultBeanEntity);
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

    @Override
    public void sendCodeToServer(String code) {
        mModel.doPostCodeSend(code)
                .subscribe(new Observer<ResultBeanEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultBeanEntity resultBeanEntity) {
                        mView.sendCodeResponse(resultBeanEntity);
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
