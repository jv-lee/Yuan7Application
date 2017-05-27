package com.yuan7.tomcat.ui.content.app;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.impl.DetailBean;
import com.yuan7.tomcat.bean.impl.HotAdBean;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/5/25.
 */

public interface AppDataContract {

    interface View extends IView {
        void bindDetailData(DetailBean bean);

        void bindHotData(HotAdBean bean);

        void bindDataEvent(int failCode, String message);
    }

    interface Presenter extends IPresenter {
        void bindDetailData(String id);

        void bindHotData();
    }

    interface Model extends IModel {
        Observable<DetailBean> doGetDetail(String id);

        Observable<HotAdBean> doGetHot();
    }

}
