package com.yuan7.tomcat.ui.main.info.news.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.info.hot.HotContract;
import com.yuan7.tomcat.ui.main.info.news.NewsContract;
import com.yuan7.tomcat.ui.main.info.news.NewsModel;
import com.yuan7.tomcat.ui.main.info.news.NewsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/15.
 */
@Module
public class NewsModule {

    private NewsContract.View view;

    public NewsModule(NewsContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    NewsContract.Model provideModel(NewsModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    NewsContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    NewsContract.Presenter providePresenter(NewsPresenter presenter) {
        return presenter;
    }

}
