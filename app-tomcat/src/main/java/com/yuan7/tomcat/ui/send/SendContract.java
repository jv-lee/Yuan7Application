package com.yuan7.tomcat.ui.send;

import com.yuan7.tomcat.base.mvp.IModel;
import com.yuan7.tomcat.base.mvp.IPresenter;
import com.yuan7.tomcat.base.mvp.IView;
import com.yuan7.tomcat.entity.ResultBeanEntity;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.PartMap;

/**
 * Created by Administrator on 2017/9/12.
 */

public interface SendContract {
    interface View extends IView {
        void bindDataEvent(int code, String message);
    }

    interface Presenter extends IPresenter {
        void sendPictureMessage(Map<String, Object> paramsMap, String[] filesPath);

        void sendVideoMessage(Map<String, Object> paramsMap, String filePath);
    }

    interface Model extends IModel {
        Observable<ResultBeanEntity> doPostAddVideo(Map<String, Object> paramsMap, MultipartBody.Part file);

        Observable<ResultBeanEntity> doPostAddPicture(Map<String, Object> paramsMap, @PartMap Map<String, RequestBody> files);
    }
}
