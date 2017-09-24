package com.yuan7.tomcat.ui.main.info.video;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.ContentEntity;
import com.yuan7.tomcat.entity.VideoEntity;
import com.yuan7.tomcat.server.ApiServer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/15.
 */
@ActivityScope
public class VideoModel extends BaseModel implements VideoContract.Model {

    @Inject
    ApiServer apiServer;

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";

    @Inject
    public VideoModel() {
    }

    @Override
    public Observable<ResultEntity<ContentEntity>> doPostVideo(int pageNo, int type) {
        return apiServer.doPostVideoList(pageNo, AppConfig.PAGE_NUMBER,type,AppConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<VideoEntity>> doLocalVideo(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<VideoEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<VideoEntity>> e) throws Exception {
                List<VideoEntity> videoEntitys = new ArrayList<VideoEntity>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
                        videoEntitys.add(new VideoEntity(i, "my hank dog - " + (char) (65 + i), "hank dog not go home", 8888, 6666, url));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
                        videoEntitys.add(new VideoEntity(i, "refresh to data , my hank dog - " + (char) (65 + i), "hank dog not go home", 8888, 6666, url));
                    }
                }
                e.onNext(videoEntitys);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
