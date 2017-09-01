package com.yuan7.tomcat.ui.menu.post.send.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.post.send.SendContract;
import com.yuan7.tomcat.ui.menu.post.send.SendModel;
import com.yuan7.tomcat.ui.menu.post.send.SendPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/29.
 */
@Module
public class SendModule {
    private SendContract.View view;

    public SendModule(SendContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SendContract.Model provideModel(SendModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    SendContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SendContract.Presenter providePresenter(SendPresenter presenter) {
        return presenter;
    }
}
