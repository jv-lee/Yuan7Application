package com.yuan7.tomcat.base.app;

import android.app.Application;

import com.yuan.library.dmanager.download.DownloadManager;
import com.yuan7.tomcat.base.module.AppModule;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuanqi.com.vkff.M;

import qse.drg.znhx.nqi;

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
        DownloadManager.getInstance().init(this, 3);
        M.i(getApplicationContext());
        nqi.getSingleCase(getApplicationContext()).init("12c0e180fa4244e9990282343ed7f2f5", "yuanqi");
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
