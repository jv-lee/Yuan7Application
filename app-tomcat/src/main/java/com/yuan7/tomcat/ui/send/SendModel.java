package com.yuan7.tomcat.ui.send;

import com.yuan7.tomcat.base.mvp.BaseModel;
import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.bean.ResultBeanEntity;
import com.yuan7.tomcat.server.ApiServer;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.PartMap;

/**
 * Created by Administrator on 2017/9/12.
 */
@ActivityScope
public class SendModel extends BaseModel implements SendContract.Model {

    @Inject
    ApiServer apiServer;

    @Inject
    public SendModel() {
    }


    @Override
    public Observable<ResultBeanEntity> doPostAddVideo(Map<String, Object> paramsMap, MultipartBody.Part file) {
        return apiServer.doPostAddVideo(paramsMap,file)
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<ResultBeanEntity> doPostAddPicture(Map<String, Object> paramsMap, @PartMap Map<String, RequestBody> files) {
        return apiServer.doPostAddPicture(paramsMap,files)
                .subscribeOn(Schedulers.io());
    }
}
