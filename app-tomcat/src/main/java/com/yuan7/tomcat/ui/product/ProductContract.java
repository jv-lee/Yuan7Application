package com.yuan7.tomcat.ui.product;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.ResultDataEntity;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/19.
 */

public interface ProductContract {
    interface View extends IView {
        void shopResponse(int code, String message);
    }

    interface Presenter extends IPresenter {
        void shopToPost(int productId, int count, String address);
    }

    interface Model extends IModel {

        Observable<ResultDataEntity> doPostShop(int productId, int count, String address);

    }
}
