package com.yuan7.tomcat.ui.menu.settings.user;

import com.yuan7.tomcat.base.mvp.BasePresenter;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.impl.FileResponseEntity;
import com.yuan7.tomcat.bean.impl.SettingsUserEntity;
import com.yuan7.tomcat.utils.LogUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2017/9/12.
 */
@ActivityScope
public class UserSettingsPresenter extends BasePresenter<UserSettingsContract.Model, UserSettingsContract.View> implements UserSettingsContract.Presenter {

    @Inject
    public UserSettingsPresenter() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindUserSettingsData() {
        mModel.getSpUserEntity()
                .subscribe(new Observer<SettingsUserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(SettingsUserEntity userEntity) {
                        mView.bindUserSettingsData(userEntity);
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
    public void updateUserSettingsData(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        mModel.doPostUpdateUser(map)
                .subscribe(new Observer<SettingsUserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(SettingsUserEntity userEntity) {
                        mView.saveUserSettingsData(userEntity);
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
    public void updateUserSettingsIcon(String filePath) {
        File file = new File(filePath);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        mModel.doPostUploadFile(body)
                .map(new Function<FileResponseEntity, String>() {
                    @Override
                    public String apply(@NonNull FileResponseEntity fileResponseEntity) throws Exception {
                        return fileResponseEntity.getObj().get(0).getUrl();
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed()) {
                            d.dispose();
                        }
                    }

                    @Override
                    public void onNext(String s) {
                        mView.responseFileUrl(s);
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
