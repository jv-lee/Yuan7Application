package com.yuan7.tomcat.ui.main.info.news;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.NewsEntity;

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
public class NewsModel extends BaseModel implements NewsContract.Model {

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";

    @Inject
    public NewsModel() {
    }

    @Override
    public Observable<NewsEntity> doGetNews(int pageNo) {
        return null;
    }

    @Override
    public Observable<List<NewsEntity>> doLocalNews(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<NewsEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<NewsEntity>> e) throws Exception {
                List<NewsEntity> newsEntitys = new ArrayList<>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
                        newsEntitys.add(new NewsEntity(i, "hank dog news content , hank dog get girl friend - " + (char) (65 + i), "14:23", "i like hank dog", 6666, new String[]{url}, 1));

                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
                        newsEntitys.add(new NewsEntity(i, "refresh to data , hank dog get girl friend - " + (char) (65 + i), "14:23", "i like hank dog", 6666, new String[]{url, url, url}, 2));

                    }
                }
                e.onNext(newsEntitys);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
