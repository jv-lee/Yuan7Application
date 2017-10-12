package com.yuan7.tomcat.base.app;

import android.app.Application;

import com.kingja.loadsir.core.LoadSir;
import com.yuan7.tomcat.base.module.AppModule;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.utils.SPUtil;
import com.yuan7.tomcat.widget.call.CustomCallback;
import com.yuan7.tomcat.widget.call.EmptyCallback;
import com.yuan7.tomcat.widget.call.ErrorCallback;
import com.yuan7.tomcat.widget.call.LoadCallback;
import com.yuan7.tomcat.widget.call.TimeoutCallback;

/**
 * Created by Administrator on 2017/5/16.
 */

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.
                builder()
                .appModule(new AppModule(this))
                .serviceModule(new ServiceModule())
                .build();
        SPUtil.getInstance(this);
        GlideImageLoader.getInstance(this);
        LoadSir.beginBuilder()
                .addCallback(new CustomCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new ErrorCallback())
                .addCallback(new LoadCallback())
                .addCallback(new TimeoutCallback())
                .setDefaultCallback(LoadCallback.class)
                .commit();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
