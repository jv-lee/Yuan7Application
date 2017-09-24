package com.yuan7.tomcat.ui.main.info.video.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.main.info.video.VideoContract;
import com.yuan7.tomcat.ui.main.info.video.VideoModel;
import com.yuan7.tomcat.ui.main.info.video.VideoPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/15.
 */
@Module
public class VideoModule {

    private VideoContract.View view;

    public VideoModule(VideoContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    VideoContract.Model provideModel(VideoModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    VideoContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    VideoContract.Presenter providePresenter(VideoPresenter presenter) {
        return presenter;
    }


}
