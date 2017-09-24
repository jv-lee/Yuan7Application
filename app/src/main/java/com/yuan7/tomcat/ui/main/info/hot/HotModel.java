package com.yuan7.tomcat.ui.main.info.hot;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.BannerEntity;
import com.yuan7.tomcat.bean.impl.ContentEntity;
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
public class HotModel extends BaseModel implements HotContract.Model {

    @Inject
    ApiServer apiServer;

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";

    @Inject
    public HotModel() {
    }


    @Override
    public Observable<BannerEntity<ContentEntity>> doPostBanner() {
        return apiServer.doPostBanner(AppConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ResultEntity<ContentEntity>> doPostHot(int pageNo) {
        return apiServer.doPostHotList(pageNo, AppConfig.PAGE_NUMBER,AppConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<com.yuan7.tomcat.entity.BannerEntity>> doLocalBanner() {
        return Observable.create(new ObservableOnSubscribe<List<com.yuan7.tomcat.entity.BannerEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<com.yuan7.tomcat.entity.BannerEntity>> e) throws Exception {
                List<com.yuan7.tomcat.entity.BannerEntity> bannerEntities = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    bannerEntities.add(new com.yuan7.tomcat.entity.BannerEntity(i, "第" + i + "个banner", url));
                }
                e.onNext(bannerEntities);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Observable<List<com.yuan7.tomcat.entity.HotEntity>> doLocalHot(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<com.yuan7.tomcat.entity.HotEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<com.yuan7.tomcat.entity.HotEntity>> e) throws Exception {
                List<com.yuan7.tomcat.entity.HotEntity> hotEntities = new ArrayList<com.yuan7.tomcat.entity.HotEntity>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
                        hotEntities.add(new com.yuan7.tomcat.entity.HotEntity(i, "game of video content - " + (char) (65 + i), "1小时前", 8888, 8888, 6666, url));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
                        hotEntities.add(new com.yuan7.tomcat.entity.HotEntity(i, "data to refresh - " + (char) (65 + i), "2小时前", 8888, 8888, 6666, url));
                    }
                }
                e.onNext(hotEntities);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
