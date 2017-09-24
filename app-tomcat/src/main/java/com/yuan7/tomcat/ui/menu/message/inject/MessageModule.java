package com.yuan7.tomcat.ui.menu.message.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.message.MessageContract;
import com.yuan7.tomcat.ui.menu.message.MessageModel;
import com.yuan7.tomcat.ui.menu.message.MessagePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/25.
 */
@Module
public class MessageModule {

    private MessageContract.View view;

    public MessageModule(MessageContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MessageContract.Model provideModel(MessageModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    MessageContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MessageContract.Presenter providePresenter(MessagePresenter presenter) {
        return presenter;
    }
}
