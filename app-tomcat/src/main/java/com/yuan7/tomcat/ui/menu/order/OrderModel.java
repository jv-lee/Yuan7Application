package com.yuan7.tomcat.ui.menu.order;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.ProductOrderEntity;
import com.yuan7.tomcat.server.ApiServer;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/9/21.
 */
@ActivityScope
public class OrderModel extends BaseModel implements OrderContract.Model {

    @Inject
    ApiServer apiServer;

    @Inject
    public OrderModel() {
    }

    @Override
    public Observable<ResultDataEntity<ProductOrderEntity>> doPostOrder(int pageNo) {
        return apiServer.doPostOrder(pageNo, AppConfig.PAGE_NUMBER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
