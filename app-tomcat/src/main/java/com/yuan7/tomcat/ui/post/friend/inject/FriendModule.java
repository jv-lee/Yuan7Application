package com.yuan7.tomcat.ui.post.friend.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.post.friend.FriendContract;
import com.yuan7.tomcat.ui.post.friend.FriendModel;
import com.yuan7.tomcat.ui.post.friend.FriendPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/21.
 */
@Module
public class FriendModule {
    private FriendContract.View view;

    public FriendModule(FriendContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    FriendContract.Model provideModel(FriendModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    FriendContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    FriendContract.Presenter providePresenter(FriendPresenter presenter) {
        return presenter;
    }
}
