package com.yuan7.tomcat.ui.main.video;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.impl.VideoBean;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/5/17.
 */

public interface VideoContract {
    interface View extends IView {
        void bindVideoData(int pageNo, VideoBean bean);

        void bindDataEvent(int eventCode, String message);
    }

    interface Presenter extends IPresenter {
        void bindVideoData(int pageNo);
    }

    interface Model extends IModel {
        Observable<VideoBean> doGetVideo(int pageNo);
    }
}
