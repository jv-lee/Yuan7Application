package com.yuan7.tomcat.ui.main.info.hot;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.BannerEntity;
import com.yuan7.tomcat.entity.impl.ContentEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/15.
 */

public interface HotContract {
    interface View extends IView {
        void bindBannerData(BannerEntity<ContentEntity> result);

        void bindHotData(int pageNo, ResultDataEntity<ContentEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindBannerData();

        void bindHotData(int pageNo);
    }

    interface Model extends IModel {
        Observable<BannerEntity<ContentEntity>> doPostBanner();

        Observable<ResultDataEntity<ContentEntity>> doPostHot(int pageNo);

        Observable<List> doLocalBanner();

        Observable<List> doLocalHot(int pageNo);
    }
}
