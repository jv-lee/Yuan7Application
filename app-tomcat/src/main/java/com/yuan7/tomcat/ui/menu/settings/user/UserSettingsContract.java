package com.yuan7.tomcat.ui.menu.settings.user;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.impl.FileResponseEntity;
import com.yuan7.tomcat.entity.impl.SettingsUserEntity;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;

/**
 * Created by Administrator on 2017/9/12.
 */

public interface UserSettingsContract {
    interface View extends IView {
        void bindUserSettingsData(SettingsUserEntity result);

        void saveUserSettingsData(SettingsUserEntity settingsUserEntity);

        void responseFileUrl(String fileUrl);

        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void bindUserSettingsData();

        void updateUserSettingsData(String key, Object value);

        void updateUserSettingsIcon(String filePath);

    }

    interface Model extends IModel {
        Observable<SettingsUserEntity> getSpUserEntity();

        Observable<SettingsUserEntity> doPostUpdateUser(Map<String, Object> params);

        Observable<FileResponseEntity> doPostUploadFile(MultipartBody.Part file);
    }
}
