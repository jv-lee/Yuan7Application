package com.yuan7.tomcat.ui.main.comm.aq;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.AQEntity;

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
public class AQModel extends BaseModel implements AQContract.Model {

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";
    private String content = "this is community friend message , this is community friend message, this is community friend message";


    @Inject
    public AQModel() {
    }

    @Override
    public Observable<List<AQEntity>> doGetAQEntity(int pageNo) {
        return null;
    }

    @Override
    public Observable<List<AQEntity>> doLocalEntity(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<AQEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<AQEntity>> e) throws Exception {
                List<AQEntity> aqEntities = new ArrayList<AQEntity>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
                        aqEntities.add(new AQEntity(i, "userName", "8-4", 6,"小兵", content, new String[]{url, url},null,null,null, 86, 88, 66, 10,url,1));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
                        aqEntities.add(new AQEntity(i, "userName", "8-4", 6,"小兵", content, null,"http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4","动物世界","http://yuan7.oss-cn-shenzhen.aliyuncs.com/image/luodiye-02.png", 86, 88, 66, 20,url,2));
                    }
                }
                e.onNext(aqEntities);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
