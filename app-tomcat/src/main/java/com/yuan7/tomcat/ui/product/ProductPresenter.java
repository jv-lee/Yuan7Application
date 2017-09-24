package com.yuan7.tomcat.ui.product;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.utils.LogUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/9/19.
 */
@ActivityScope
public class ProductPresenter extends BasePresenter<ProductContract.Model, ProductContract.View> implements ProductContract.Presenter {

    @Inject
    public ProductPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void shopToPost(int productId, int count, String address) {
        mModel.doPostShop(productId, count, address)
                .subscribe(new Observer<ResultDataEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultDataEntity resultEntity) {
                        switch (resultEntity.getCode()) {
                            case 2000:
                                mView.shopResponse(resultEntity.getCode(), resultEntity.getMessage());
                                break;
                            case 4401:
                                mView.shopResponse(resultEntity.getCode(), resultEntity.getMessage());
                                break;
                            case 4402:
                                mView.shopResponse(resultEntity.getCode(), resultEntity.getMessage());
                                break;
                            case 4403:
                                mView.shopResponse(resultEntity.getCode(), resultEntity.getMessage());
                                break;
                            default:
                                mView.shopResponse(resultEntity.getCode(), resultEntity.getMessage());
                                break;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.getStackTraceString(e);
                        LogUtil.e(e.getMessage());
                        mView.shopResponse(0, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
