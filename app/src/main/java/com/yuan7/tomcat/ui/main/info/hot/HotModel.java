package com.yuan7.tomcat.ui.main.info.hot;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.BannerEntity;
import com.yuan7.tomcat.entity.HotEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/15.
 */
@ActivityScope
public class HotModel extends BaseModel implements HotContract.Model {

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";

    @Inject
    public HotModel() {
    }


    @Override
    public Observable<List<BannerEntity>> doGetBanner() {
        return null;
    }

    @Override
    public Observable<List<HotEntity>> doGetHot(int pageNo) {
        return null;
    }

    @Override
    public Observable<List<BannerEntity>> doLocalBanner() {
        return Observable.create(new ObservableOnSubscribe<List<BannerEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<BannerEntity>> e) throws Exception {
                List<BannerEntity> bannerEntities = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    bannerEntities.add(new BannerEntity(i, "第" + i + "个banner", url));
                }
                e.onNext(bannerEntities);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Observable<List<HotEntity>> doLocalHot(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<HotEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<HotEntity>> e) throws Exception {
                List<HotEntity> hotEntities = new ArrayList<HotEntity>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
                        hotEntities.add(new HotEntity(i, "game of video content - " + (char) (65 + i), "1小时前", 8888, 8888, 6666, url));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
                        hotEntities.add(new HotEntity(i, "data to refresh - " + (char) (65 + i), "2小时前", 8888, 8888, 6666, url));
                    }
                }
                e.onNext(hotEntities);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
