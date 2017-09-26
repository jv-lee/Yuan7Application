package com.yuan7.tomcat.ui.menu.settings.user;

import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.entity.impl.FileResponseEntity;
import com.yuan7.tomcat.entity.impl.SettingsUserEntity;
import com.yuan7.tomcat.server.ApiServer;
import com.yuan7.tomcat.utils.SPUtil;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * Created by Administrator on 2017/9/12.
 */
@ActivityScope
public class UserSettingsModel extends BaseModel implements UserSettingsContract.Model {

    @Inject
    ApiServer apiServer;

    private String iconUrl = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2002780062,3123189129&fm=58";
    private String testName = "testName";
    private String testBirthday = "1993-08-22";

    @Inject
    public UserSettingsModel() {

    }

    @Override
    public Observable<SettingsUserEntity> getSpUserEntity() {
        return Observable.create(new ObservableOnSubscribe<SettingsUserEntity>() {
            @Override
            public void subscribe(ObservableEmitter<SettingsUserEntity> e) throws Exception {
                SettingsUserEntity settingsUserEntity = new SettingsUserEntity();
                SettingsUserEntity.ObjBean userBean = new SettingsUserEntity.ObjBean();
                userBean.setId((Integer) SPUtil.get(UserParams.USER_ID, 0));
                userBean.setImage((String) SPUtil.get(UserParams.USER_ICON_URL, iconUrl));
                userBean.setName((String) SPUtil.get(UserParams.USER_NAME, testName));
                userBean.setSex((Boolean) SPUtil.get(UserParams.USER_SEX, true));
                userBean.setBirthday((String) SPUtil.get(UserParams.USER_BIRTHDAY, testBirthday));
                userBean.setLevel((Integer) SPUtil.get(UserParams.USER_LEVEL, 0));
                settingsUserEntity.setObj(userBean);
                e.onNext(settingsUserEntity);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SettingsUserEntity> doPostUpdateUser(Map<String, Object> params) {
        return apiServer.doPostUpdateUser(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<FileResponseEntity> doPostUploadFile(MultipartBody.Part file) {
        return apiServer.doPostUploadFile(file)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
