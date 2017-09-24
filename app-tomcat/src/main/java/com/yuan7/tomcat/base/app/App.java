package com.yuan7.tomcat.base.app;

import android.app.Application;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.module.AppModule;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.utils.SPUtil;

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
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
