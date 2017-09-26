package com.yuan7.tomcat.ui.main.recommend;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.impl.RecommendBean;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/5/18.
 */

public interface RecommendContract {

    interface View extends IView {
        void bindRecommendData(int pageNo, RecommendBean bean);

        void bindDataEvent(int eventCode, String message);
    }

    interface Presenter extends IPresenter {
        void bindRecommendData(int pageNo);
    }

    interface Model extends IModel {
        Observable<RecommendBean> doGetRecommend(int pageNo);
    }
}
