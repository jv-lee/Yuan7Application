package com.yuan7.tomcat.ui.product;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.server.ApiServer;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/9/19.
 */
@ActivityScope
public class ProductModel extends BaseModel implements ProductContract.Model {

    @Inject
    ApiServer apiServer;

    @Inject
    public ProductModel() {
    }

    @Override
    public Observable<ResultDataEntity> doPostShop(int productId, int count, String address) {
        return apiServer.doPostAddOrder(productId, count, address)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
