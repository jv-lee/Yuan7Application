package com.yuan7.tomcat.ui.main.comm.aq;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.ContentEntity;


import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/21.
 */

public interface AQContract {
    interface View extends IView {
        void bindAQData(int pageNo, ResultDataEntity<ContentEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindAQData(int pageNo, int type);
    }

    interface Model extends IModel {
        Observable<ResultDataEntity<ContentEntity>> doPostAQEntity(int pageNo, int type);

        Observable<List<ContentEntity>> doLocalEntity(int pageNo);
    }
}
