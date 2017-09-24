package com.yuan7.tomcat.ui.post.reply;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.ReplyEntity;
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
public class ReplyModel extends BaseModel implements ReplyContract.Model {

    @Inject
    ApiServer apiServer;

    @Inject
    public ReplyModel() {
    }

    @Override
    public Observable<ResultEntity<ReplyEntity>> doPostReply(int pageNo, int userId) {
        if (userId != 0) {
            return apiServer.doPostUserReply(pageNo, AppConfig.PAGE_NUMBER, userId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        } else {
            return apiServer.doPostReply(pageNo, AppConfig.PAGE_NUMBER)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }

    }

    @Override
    public Observable<List<ReplyEntity>> doLocalReply(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<ReplyEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ReplyEntity>> e) throws Exception {
                List<ReplyEntity> shopEntities = new ArrayList<>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
//                        shopEntities.add(new ReplyEntity(i, "Tomcat title", "this is tomcat app reply module content message.",
//                                "2017-08-07", 3210, 3210, 3110));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
//                        shopEntities.add(new ReplyEntity(i, "refresh tomcat", "this is tomcat app refresh content message.",
//                                "2017-06-05", 32100, 32100, 31100));
                    }
                }
                e.onNext(shopEntities);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
