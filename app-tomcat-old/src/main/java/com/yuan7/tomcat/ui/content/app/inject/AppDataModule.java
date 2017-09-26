package com.yuan7.tomcat.ui.content.app.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.content.app.AppDataContract;
import com.yuan7.tomcat.ui.content.app.AppDataModel;
import com.yuan7.tomcat.ui.content.app.AppDataPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/5/25.
 */
@Module
public class AppDataModule {

    private AppDataContract.View view;

    public AppDataModule(AppDataContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    AppDataContract.Model provideModel(AppDataModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    AppDataContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    AppDataContract.Presenter providePresenter(AppDataPresenter presenter) {
        return presenter;
    }

}
