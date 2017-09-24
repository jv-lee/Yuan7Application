package com.yuan7.tomcat.ui.main.comm.community;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.ContentEntity;
import com.yuan7.tomcat.entity.CommunityEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/21.
 */

public interface CommunityContract {
    interface View extends IView {
        void bindCommunityData(int pageNo,ResultEntity<ContentEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindCommunityData(int pageNo, int type);
    }

    interface Model extends IModel {
        Observable<ResultEntity<ContentEntity>> doPostCommunity(int pageNo, int type);

        Observable<List<CommunityEntity>> doLocalCommunity(int pageNo);
    }
}
