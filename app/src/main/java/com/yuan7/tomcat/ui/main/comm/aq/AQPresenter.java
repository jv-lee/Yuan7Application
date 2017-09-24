package com.yuan7.tomcat.ui.main.comm.aq;

import android.util.Log;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.ContentEntity;
import com.yuan7.tomcat.entity.AQEntity;
import com.yuan7.tomcat.utils.LogUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/21.
 */
@ActivityScope
public class AQPresenter extends BasePresenter<AQContract.Model, AQContract.View> implements AQContract.Presenter {

    @Inject
    public AQPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindAQData(final int pageNo, int type) {
        mModel.doPostAQEntity(pageNo, type)
                .subscribe(new Observer<ResultEntity<ContentEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultEntity<ContentEntity> resultEntity) {
                        mView.bindAQData(pageNo, resultEntity);
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
//        mModel.doLocalEntity(pageNo).subscribe(new Observer<List<AQEntity>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                if (d.isDisposed()) {
//                    d.dispose();
//                }
//            }
//
//            @Override
//            public void onNext(List<AQEntity> aqEntities) {
//                mView.bindAQData(aqEntities);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }
}
