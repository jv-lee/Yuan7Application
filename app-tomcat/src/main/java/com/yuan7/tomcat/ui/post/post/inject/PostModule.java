package com.yuan7.tomcat.ui.post.post.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.post.post.PostContract;
import com.yuan7.tomcat.ui.post.post.PostModel;
import com.yuan7.tomcat.ui.post.post.PostPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/29.
 */
@Module
public class PostModule {
    private PostContract.View view;

    public PostModule(PostContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    PostContract.Model provideModel(PostModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    PostContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    PostContract.Presenter providePresenter(PostPresenter presenter) {
        return presenter;
    }
}
