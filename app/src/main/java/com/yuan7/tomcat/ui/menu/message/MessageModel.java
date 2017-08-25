package com.yuan7.tomcat.ui.menu.message;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.MessageEntity;

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
public class MessageModel extends BaseModel implements MessageContract.Model{

    private String url = "https://developer.android.google.cn/images/home/kotlin-android.svg";
    private String content = "this is message content";

    @Inject
    public MessageModel(){}

    @Override
    public Observable<List<MessageEntity>> doGetMessage(int pageNo) {
        return null;
    }

    @Override
    public Observable<List<MessageEntity>> doLocalMessage(final int pageNo) {
        return Observable.create(new ObservableOnSubscribe<List<MessageEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<MessageEntity>> e) throws Exception {
                List<MessageEntity> messageEntities = new ArrayList<>();
                if (pageNo == 1) {
                    for (int i = 0; i < 10; i++) {
                        messageEntities.add(new MessageEntity(i,"userName",content,"1小时前",url));
                    }
                } else if (pageNo == 2) {
                    for (int i = 0; i < 10; i++) {
                        messageEntities.add(new MessageEntity(i,"userName",content+"\n"+content,"3天前",url));
                    }
                }
                e.onNext(messageEntities);
                e.onComplete();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
