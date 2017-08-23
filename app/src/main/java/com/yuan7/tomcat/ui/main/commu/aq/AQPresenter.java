package com.yuan7.tomcat.ui.main.commu.aq;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.AQEntity;

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
    public void bindAQData(int pageNo) {
        mModel.doLocalEntity(pageNo).subscribe(new Observer<List<AQEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (d.isDisposed()) {
                    d.dispose();
                }
            }

            @Override
            public void onNext(List<AQEntity> aqEntities) {
                mView.bindAQData(aqEntities);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
