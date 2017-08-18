package com.yuan7.tomcat.ui.main.info.news;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.NewsEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/15.
 */

public interface NewsContract {
    interface View extends IView {
        void bindNewsData(List<NewsEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {

        void bindNewsData(int pageNo);
    }

    interface Model extends IModel {
        Observable<NewsEntity> doGetNews(int pageNo);

        Observable<List<NewsEntity>> doLocalNews(int pageNo);
    }
}
