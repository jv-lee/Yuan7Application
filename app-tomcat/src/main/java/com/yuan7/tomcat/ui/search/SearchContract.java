package com.yuan7.tomcat.ui.search;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.SearchEntity;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/21.
 */

public interface SearchContract {
    interface View extends IView {
        void bindSearchData(int pageNo, ResultDataEntity<SearchEntity> resultEntity);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindSearchData(String title, int pageNo);
    }

    interface Model extends IModel {
        Observable<ResultDataEntity<SearchEntity>> doPostSearch(String title, int pageNo);
    }
}
