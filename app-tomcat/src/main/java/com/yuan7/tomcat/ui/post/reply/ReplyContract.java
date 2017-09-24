package com.yuan7.tomcat.ui.post.reply;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.ResultDataEntity;
import com.yuan7.tomcat.bean.impl.ReplyEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/29.
 */

public interface ReplyContract {
    interface View extends IView {
        void bindReplyData(int page, ResultDataEntity<ReplyEntity> result);

        void bindDataEvent(int code, String Shop);
    }

    interface Presenter extends IPresenter {
        void bindReplyData(int pageNo, int userId);
    }

    interface Model extends IModel {
        Observable<ResultDataEntity<ReplyEntity>> doPostReply(int pageNo, int userId);

        Observable<List<ReplyEntity>> doLocalReply(int pageNo);
    }
}
