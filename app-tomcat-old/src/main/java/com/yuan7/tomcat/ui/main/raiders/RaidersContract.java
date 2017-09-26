package com.yuan7.tomcat.ui.main.raiders;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.impl.RaidersBean;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/5/17.
 */

public interface RaidersContract {

    interface View extends IView {
        void bindRaidersData(int pageNo, RaidersBean bean);

        void bindDataEvent(int eventCode, String message);
    }

    interface Presenter extends IPresenter {
        void bindRaidersData(int pageNo);
    }

    interface Model extends IModel {
        Observable<RaidersBean> doGetRaiders(int pageNo);
    }
}
