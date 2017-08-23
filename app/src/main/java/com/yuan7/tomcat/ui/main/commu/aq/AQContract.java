package com.yuan7.tomcat.ui.main.commu.aq;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.AQEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/21.
 */

public interface AQContract {
    interface View extends IView {
        void bindAQData(List<AQEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindAQData(int pageNo);
    }

    interface Model extends IModel {
        Observable<List<AQEntity>> doGetAQEntity(int pageNo);

        Observable<List<AQEntity>> doLocalEntity(int pageNo);
    }
}
