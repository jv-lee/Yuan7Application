package com.yuan7.tomcat.ui.main.comm.community;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.ContentEntity;
import com.yuan7.tomcat.entity.CommunityEntity;
import com.yuan7.tomcat.ui.main.info.InfoFragment;
import com.yuan7.tomcat.utils.LogUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/21.
 */
@ActivityScope
public class CommunityPresenter extends BasePresenter<CommunityContract.Model, CommunityContract.View> implements CommunityContract.Presenter {

    @Inject
    public CommunityPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindCommunityData(final int pageNo, int type) {
        mModel.doPostCommunity(pageNo, type).subscribe(new Observer<ResultEntity<ContentEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (d.isDisposed()) {
                    d.dispose();
                }
            }

            @Override
            public void onNext(ResultEntity<ContentEntity> resultEntity) {
                mView.bindCommunityData(pageNo,resultEntity);
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.getStackTraceString(e);
                LogUtil.e(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
//        mModel.doLocalCommunity(pageNo)
//                .subscribe(new Observer<List<CommunityEntity>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        if (d.isDisposed()) {
//                            d.dispose();
//                        }
//                    }
//
//                    @Override
//                    public void onNext(List<CommunityEntity> communityEntities) {
//                        mView.bindCommunityData(communityEntities);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

}
