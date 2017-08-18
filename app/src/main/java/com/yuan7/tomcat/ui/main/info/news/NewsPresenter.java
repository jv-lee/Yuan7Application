package com.yuan7.tomcat.ui.main.info.news;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.NewsEntity;

import java.util.List;

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
    public void bindNewsData(int pageNo) {
        mModel.doLocalNews(pageNo)
                .subscribe(new Observer<List<NewsEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(List<NewsEntity> newsEntities) {
                        mView.bindNewsData(newsEntities);
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
