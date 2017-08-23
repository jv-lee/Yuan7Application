package com.yuan7.tomcat.ui.main.commu.community;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.CommunityEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/21.
 */
@ActivityScope
public class CommunityModel extends BaseModel implements CommunityContract.Model {

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";
    private String content = "this is community friend message , this is community friend message, this is community friend message";

    @Inject
    public CommunityModel() {
    }

    @Override
    public Observable<List<CommunityEntity>> doGetCommunity(int pageNo) {
        return null;
    }

    @Override
    public Observable<List<CommunityEntity>> doLocalCommunity(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<CommunityEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CommunityEntity>> e) throws Exception {
                List<CommunityEntity> communityEntities = new ArrayList<CommunityEntity>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
                        communityEntities.add(new CommunityEntity(i, "userName", "8-4", "iphone6", content, false, new String[]{url, url}, 86, 88, 66, url));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
                        communityEntities.add(new CommunityEntity(i, "userName", "8-4", "iphone6", content, false, new String[]{url, url, url}, 86, 88, 66, url));
                    }
                }
                e.onNext(communityEntities);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
