package com.yuan7.tomcat.ui.main.home;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.impl.BannerBean;
import com.yuan7.tomcat.bean.impl.NewsBean;
import com.yuan7.tomcat.bean.impl.ProPagateBean;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/5/17.
 */

public interface HomeContract {

    interface View extends IView {
        void bindBannerData(List<BannerBean.ResultBean> result, List<String> images);

        void bindPropagateData(List<ProPagateBean.ResultBean> result);

        void bindNewsData(int pageNo, NewsBean newsBean);

        void bindDataEvent(int failCode, String message);
    }

    interface Presenter extends IPresenter {
        void bindBannerData();

        void bindPropagateData();

        void bindNewsData(int pageNo);
    }

    interface Model extends IModel {
        Observable<BannerBean> doGetBanner();

        Observable<ProPagateBean> doGetProPatate();

        Observable<NewsBean> doGetNews(int pageNo);
    }
}
