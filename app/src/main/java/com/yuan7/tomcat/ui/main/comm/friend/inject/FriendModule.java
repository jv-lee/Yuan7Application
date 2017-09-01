package com.yuan7.tomcat.ui.main.comm.friend.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.comm.friend.FriendContract;
import com.yuan7.tomcat.ui.main.comm.friend.FriendModel;
import com.yuan7.tomcat.ui.main.comm.friend.FriendPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/21.
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
