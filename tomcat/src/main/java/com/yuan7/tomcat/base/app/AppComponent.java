package com.yuan7.tomcat.base.app;

import android.app.Application;

import com.yuan7.tomcat.base.module.AppModule;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.service.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/5/17.
 */
@Singleton
@Component(modules = {AppModule.class, ServiceModule.class})
public interface AppComponent {

    Application application();

    ApiService apiService();

}
