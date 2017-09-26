package com.yuan7.tomcat.ui.main.info.news;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.ContentEntity;
import com.yuan7.tomcat.utils.LogUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/15.
 */
@ActivityScope
public class NewsPresenter extends BasePresenter<NewsContract.Model, NewsContract.View> implements NewsContract.Presenter {

    @Inject
    public NewsPresenter() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindNewsData(final int pageNo, int type) {
        mModel.doPostNews(pageNo, type)
                .subscribe(new Observer<ResultDataEntity<ContentEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultDataEntity<ContentEntity> newsEntity) {
                        mView.bindNewsData(pageNo, newsEntity);
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
//        mModel.doLocalNews(pageNo)
//                .subscribe(new Observer<List<NewsEntity>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        if (d.isDisposed()) {
//                            d.dispose();
//                        }
//                    }
//
//                    @Override
//                    public void onNext(List<NewsEntity> newsEntities) {
//                        mView.bindNewsData(newsEntities);
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
