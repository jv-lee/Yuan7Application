package com.yuan7.tomcat.ui.post.post;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.PostEntity;
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
 * Created by Administrator on 2017/8/29.
 */
@ActivityScope
public class PostModel extends BaseModel implements PostContract.Model {

    @Inject
    ApiServer apiServer;

    @Inject
    public PostModel() {
    }

    @Override
    public Observable<ResultDataEntity<PostEntity>> doPostSend(int pageNo, int userId) {
        if (userId != 0) {
            return apiServer.doPostUserSend(pageNo, AppConfig.PAGE_NUMBER, userId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        } else {
            return apiServer.doPostSend(pageNo, AppConfig.PAGE_NUMBER)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    }

    @Override
    public Observable<List<PostEntity>> doLocalSend(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<PostEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<PostEntity>> e) throws Exception {
                List<PostEntity> shopEntities = new ArrayList<>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
//                        shopEntities.add(new PostEntity(i, "Tomcat title", "this is tomcat app post module content message.",
//                                "28", "八月", 3210, 3210, 3110));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
//                        shopEntities.add(new PostEntity(i, "refresh tomcat", "this is tomcat app refresh content message.",
//                                "5", "六月", 32100, 32100, 31100));
                    }
                }
                e.onNext(shopEntities);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
