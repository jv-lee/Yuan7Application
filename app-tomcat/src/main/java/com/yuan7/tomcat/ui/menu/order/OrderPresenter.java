package com.yuan7.tomcat.ui.menu.order;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.ProductOrderEntity;
import com.yuan7.tomcat.utils.LogUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/9/21.
 */
@ActivityScope
public class OrderPresenter extends BasePresenter<OrderContract.Model, OrderContract.View> implements OrderContract.Presenter {

    @Inject
    public OrderPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindOrderData(final int pageNo) {
        mModel.doPostOrder(pageNo)
                .subscribe(new Observer<ResultDataEntity<ProductOrderEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultDataEntity<ProductOrderEntity> resultEntity) {
                        mView.bindOrderData(pageNo, resultEntity);
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
