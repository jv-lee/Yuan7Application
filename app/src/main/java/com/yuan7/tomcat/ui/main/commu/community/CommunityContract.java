package com.yuan7.tomcat.ui.main.commu.community;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.CommunityEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/21.
 */

public interface CommunityContract {
    interface View extends IView {
        void bindCommunityData(List<CommunityEntity> result);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindCommunityData(int pageNo);
    }

    interface Model extends IModel {
        Observable<List<CommunityEntity>> doGetCommunity(int pageNo);

        Observable<List<CommunityEntity>> doLocalCommunity(int pageNo);
    }
}
