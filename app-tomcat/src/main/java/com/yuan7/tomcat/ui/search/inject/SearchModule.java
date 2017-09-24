package com.yuan7.tomcat.ui.search.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.search.SearchContract;
import com.yuan7.tomcat.ui.search.SearchModel;
import com.yuan7.tomcat.ui.search.SearchPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/21.
 */
@Module
public class SearchModule {
    private SearchContract.View view;

    public SearchModule(SearchContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SearchContract.Model provideModel(SearchModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    SearchContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SearchContract.Presenter providePresenter(SearchPresenter presenter) {
        return presenter;
    }
}
