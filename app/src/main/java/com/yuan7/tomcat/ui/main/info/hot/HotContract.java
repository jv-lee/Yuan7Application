package com.yuan7.tomcat.ui.main.info.hot;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.BannerEntity;
import com.yuan7.tomcat.bean.impl.ContentEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/15.
 */

public interface HotContract {
    interface View extends IView {
        void bindBannerData(BannerEntity<ContentEntity> result);

        void bindHotData(int pageNo, ResultEntity<ContentEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindBannerData();

        void bindHotData(int pageNo);
    }

    interface Model extends IModel {
        Observable<BannerEntity<ContentEntity>> doPostBanner();

        Observable<ResultEntity<ContentEntity>> doPostHot(int pageNo);

        Observable<List<com.yuan7.tomcat.entity.BannerEntity>> doLocalBanner();

        Observable<List<com.yuan7.tomcat.entity.HotEntity>> doLocalHot(int pageNo);
    }
}
