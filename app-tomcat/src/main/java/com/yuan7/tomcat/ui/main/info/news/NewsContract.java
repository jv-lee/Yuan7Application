package com.yuan7.tomcat.ui.main.info.news;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.ContentEntity;
import com.yuan7.tomcat.entity.NewsEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/15.
 */

public interface NewsContract {
    interface View extends IView {
        void bindNewsData(int pageNo,ResultDataEntity<ContentEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {

        void bindNewsData(int pageNo,int type);
    }

    interface Model extends IModel {
        Observable<ResultDataEntity<ContentEntity>> doPostNews(int pageNo, int type);

        Observable<List<NewsEntity>> doLocalNews(int pageNo);
    }
}
