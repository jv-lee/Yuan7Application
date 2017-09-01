package com.yuan7.tomcat.ui.menu.post.send;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.SendEntity;

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
public class SendModel extends BaseModel implements SendContract.Model{

    @Inject
    public SendModel(){}

    @Override
    public Observable<List<SendEntity>> doGetSend(int pageNo) {
        return null;
    }

    @Override
    public Observable<List<SendEntity>> doLocalSend(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<SendEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<SendEntity>> e) throws Exception {
                List<SendEntity> shopEntities = new ArrayList<>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
                        shopEntities.add(new SendEntity(i,"Tomcat title","this is tomcat app post module content message.",
                                "28","八月",3210,3210,3110));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
                        shopEntities.add(new SendEntity(i,"refresh tomcat","this is tomcat app refresh content message.",
                                "5","六月",32100,32100,31100));
                    }
                }
                e.onNext(shopEntities);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
