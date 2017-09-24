package com.yuan7.tomcat.ui.menu.message;

import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.MessageEntity;
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
 * Created by Administrator on 2017/8/25.
 */
@ActivityScope
public class MessageModel extends BaseModel implements MessageContract.Model {

    @Inject
    ApiServer apiServer;

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";
    private String content = "this is message content";

    @Inject
    public MessageModel() {
    }

    @Override
    public Observable<ResultEntity<MessageEntity>> doPostMessage(int pageNo, int type) {
        return apiServer.doPostMessage(type, pageNo, AppConfig.PAGE_NUMBER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<MessageEntity>> doLocalMessage(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<MessageEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<MessageEntity>> e) throws Exception {
                List<MessageEntity> messageEntities = new ArrayList<>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
//                        messageEntities.add(new MessageEntity(i, "userName", content, "1小时前", url));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
//                        messageEntities.add(new MessageEntity(i, "userName", content + "\n" + content, "3天前", url));
                    }
                }
                e.onNext(messageEntities);
                e.onComplete();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
