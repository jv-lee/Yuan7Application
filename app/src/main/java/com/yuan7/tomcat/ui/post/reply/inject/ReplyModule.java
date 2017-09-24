package com.yuan7.tomcat.ui.post.reply.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.post.reply.ReplyContract;
import com.yuan7.tomcat.ui.post.reply.ReplyModel;
import com.yuan7.tomcat.ui.post.reply.ReplyPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/29.
 */
@Module
public class ReplyModule {
    private ReplyContract.View view;

    public ReplyModule(ReplyContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ReplyContract.Model provideModel(ReplyModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    ReplyContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ReplyContract.Presenter providePresenter(ReplyPresenter presenter) {
        return presenter;
    }
}
