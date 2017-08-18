package com.yuan7.tomcat.ui.main.info.video;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.VideoEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/15.
 */

public interface VideoContract {

    interface View extends IView {
        void bindVideoData(List<VideoEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {

        void bindVideoData(int pageNo);
    }

    interface Model extends IModel {
        Observable<VideoEntity> doGetVideo(int pageNo);

        Observable<List<VideoEntity>> doLocalVideo(int pageNo);
    }
}
