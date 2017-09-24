package com.yuan7.tomcat.ui.post.post;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.PostEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/29.
 */

public interface PostContract {
    interface View extends IView {
        void bindSendData(int pageNo, ResultDataEntity<PostEntity> result);

        void bindDataEvent(int code, String Shop);
    }

    interface Presenter extends IPresenter {
        void bindSendData(int pageNo,int userId);
    }

    interface Model extends IModel {
        Observable<ResultDataEntity<PostEntity>> doPostSend(int pageNo, int userId);

        Observable<List<PostEntity>> doLocalSend(int pageNo);
    }
}
