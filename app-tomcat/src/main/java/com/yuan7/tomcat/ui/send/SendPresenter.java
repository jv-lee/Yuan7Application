package com.yuan7.tomcat.ui.send;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultBeanEntity;
import com.yuan7.tomcat.utils.LogUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2017/9/12.
 */
@ActivityScope
public class SendPresenter extends BasePresenter<SendContract.Model, SendContract.View> implements SendContract.Presenter {

    @Inject
    public SendPresenter() {
    }


    @Override
    public void onDestroy() {

    }

    @Override
    public void sendPictureMessage(Map<String, Object> paramsMap, String[] filesPath) {
        List<File> files = new ArrayList<>();
        Map<String, RequestBody> fileParams = new HashMap<>();

        for (int i = 0; i < filesPath.length; i++) {
            files.add(new File(filesPath[i]));
        }

        for (int i = 0; i < files.size(); i++) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), files.get(i));
            fileParams.put("file\"; filename=\"" + files.get(i).getName() + "", requestBody);
        }

        mModel.doPostAddPicture(paramsMap, fileParams)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultBeanEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultBeanEntity s) {
                        mView.bindDataEvent(s.getCode(), s.getMessage());
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
    }

    @Override
    public void sendVideoMessage(Map<String, Object> paramsMap, String filePath) {
        File file = new File(filePath);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("videoFile", file.getName(), requestFile);

        mModel.doPostAddVideo(paramsMap, body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultBeanEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(ResultBeanEntity s) {
                        mView.bindDataEvent(s.getCode(), s.getMessage());
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
    }
}
