package com.yuan7.tomcat.ui.menu.order;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.ProductOrderEntity;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/21.
 */

public interface OrderContract {
    interface View extends IView {
        void bindOrderData(int pageNo, ResultDataEntity<ProductOrderEntity> resultEntity);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindOrderData(int pageNo);
    }

    interface Model extends IModel {
        Observable<ResultDataEntity<ProductOrderEntity>> doPostOrder(int pageNo);
    }
}
