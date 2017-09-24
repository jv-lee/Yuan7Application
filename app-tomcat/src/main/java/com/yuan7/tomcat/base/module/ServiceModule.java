package com.yuan7.tomcat.base.module;


import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.server.ApiServer;
import com.yuan7.tomcat.utils.LogUtil;
import com.yuan7.tomcat.utils.SPUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/4/10.
 */

@Module
public class ServiceModule {

    public static final String BASE_URL = Constant.BASE_URL;
    private static final long DEFAULT_TIMEOUT = 5; //连接时间为最小
    private static final long READ_TIMEOUT = 5;
    private static final long WRITE_TIMEOUT = 5;

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {

                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder1 = request.newBuilder();
                        Request build = builder1.addHeader("yuan7-token", (String) SPUtil.get(UserParams.USER_TOKEN, "")).build();
                        return chain.proceed(build);
                    }
                })
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    @Singleton
    @Provides
    ApiServer provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiServer.class);
    }


}
