package com.yuan7.tomcat.ui.menu.post.reply;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.ReplyEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/29.
 */

public interface ReplyContract {
    interface View extends IView {
        void bindReplyData(List<ReplyEntity> result);

        void bindDataEvent(int code, String Shop);
    }

    interface Presenter extends IPresenter {
        void bindReplyData(int pageNo);
    }

    interface Model extends IModel {
        Observable<List<ReplyEntity>> doGetReply(int pageNo);

        Observable<List<ReplyEntity>> doLocalReply(int pageNo);
    }
}
