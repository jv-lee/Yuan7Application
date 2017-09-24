package com.yuan7.tomcat.ui.main.comm.community;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.ContentEntity;
import com.yuan7.tomcat.entity.CommunityEntity;
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
 * Created by Administrator on 2017/8/21.
 */
@ActivityScope
public class CommunityModel extends BaseModel implements CommunityContract.Model {

    @Inject
    ApiServer apiServer;

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";
    private String content = "this is community friend message , this is community friend message, this is community friend message";

    @Inject
    public CommunityModel() {
    }

    @Override
    public Observable<ResultEntity<ContentEntity>> doPostCommunity(int pageNo, int type) {
        return apiServer.doPostCommunityList(pageNo, AppConfig.PAGE_NUMBER, type, AppConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<CommunityEntity>> doLocalCommunity(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<CommunityEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CommunityEntity>> e) throws Exception {
                List<CommunityEntity> communityEntities = new ArrayList<CommunityEntity>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
                        communityEntities.add(new CommunityEntity(i, "userName", "8-4", 6,"小兵", content, new String[]{url, url},null,null,null, 86, 88, 66, url,1));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
                        communityEntities.add(new CommunityEntity(i, "userName", "8-4", 6,"小兵", content, null,"http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4","动物世界","http://yuan7.oss-cn-shenzhen.aliyuncs.com/image/luodiye-02.png", 86, 88, 66, url,2));
                    }
                }
                e.onNext(communityEntities);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
