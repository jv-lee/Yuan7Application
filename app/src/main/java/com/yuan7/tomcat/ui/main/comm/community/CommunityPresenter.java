package com.yuan7.tomcat.ui.main.comm.community;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.CommunityEntity;

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
    public void bindCommunityData(int pageNo) {
        mModel.doLocalCommunity(pageNo)
                .subscribe(new Observer<List<CommunityEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(List<CommunityEntity> communityEntities) {
                        mView.bindCommunityData(communityEntities);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
