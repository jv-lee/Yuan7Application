package com.yuan7.tomcat.ui.main.recommend.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.recommend.RecommendContract;
import com.yuan7.tomcat.ui.main.recommend.RecommendModel;
import com.yuan7.tomcat.ui.main.recommend.RecommendPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/5/18.
 */
@Module
public class RecommendModule {

    private RecommendContract.View view;

    public RecommendModule(RecommendContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    RecommendContract.Model provideModel(RecommendModel recommendModel) {
        return recommendModel;
    }

    @ActivityScope
    @Provides
    RecommendContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    RecommendContract.Presenter providePresenter(RecommendPresenter recommendPresenter) {
        return recommendPresenter;
    }

}
