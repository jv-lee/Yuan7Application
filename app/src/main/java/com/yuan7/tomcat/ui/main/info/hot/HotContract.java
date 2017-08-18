package com.yuan7.tomcat.ui.main.info.hot;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.BannerEntity;
import com.yuan7.tomcat.entity.HotEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/15.
 */

public interface HotContract {
    interface View extends IView {
        void bindBannerData(List<BannerEntity> result, List<String> images);

        void bindHotData(List<HotEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindBannerData();

        void bindHotData(int pageNo);
    }

    interface Model extends IModel {
        Observable<List<BannerEntity>> doGetBanner();

        Observable<List<HotEntity>> doGetHot(int pageNo);

        Observable<List<BannerEntity>> doLocalBanner();

        Observable<List<HotEntity>> doLocalHot(int pageNo);
    }
}
