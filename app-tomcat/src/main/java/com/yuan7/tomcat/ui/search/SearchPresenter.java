package com.yuan7.tomcat.ui.search;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.SearchEntity;
import com.yuan7.tomcat.utils.LogUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/9/21.
 */
@ActivityScope
public class SearchPresenter extends BasePresenter<SearchContract.Model, SearchContract.View> implements SearchContract.Presenter {

    @Inject
    public SearchPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindSearchData(String title, final int pageNo) {
        mModel.doPostSearch(title, pageNo)
                .subscribe(new Observer<ResultDataEntity<SearchEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultDataEntity<SearchEntity> searchEntityResultEntity) {
                        mView.bindSearchData(pageNo, searchEntityResultEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.getStackTraceString(e);
                        LogUtil.e(e.getMessage());
                        mView.bindDataEvent(0, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
