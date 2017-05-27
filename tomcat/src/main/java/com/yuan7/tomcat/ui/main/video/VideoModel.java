package com.yuan7.tomcat.ui.main.video;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.VideoBean;
import com.yuan7.tomcat.service.ApiService;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2017/5/18.
 */
@ActivityScope
public class VideoModel extends BaseModel implements VideoContract.Model {

    @Inject
    ApiService service;

    @Inject
    public VideoModel() {
    }

    @Override
    public Observable<VideoBean> doGetVideo(int pageNo) {
        return service.doGetVideo(pageNo);
    }
}
