package com.yuan7.tomcat.ui.main.start;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.StartEntity;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/15.
 */

public interface StartContract {
    interface View extends IView {
        void bindStartData(StartEntity resultEntity);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindStartData();
    }

    interface Model extends IModel {
        Observable<StartEntity> doPostStart();
    }
}
