package com.yuan7.tomcat.base.app;

import android.app.Application;

import com.github.client.m.Am;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.GoogleDotView;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.yuan.library.dmanager.download.DownloadManager;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.module.AppModule;
import com.yuan7.tomcat.base.module.ServiceModule;

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
        Am.getInstance(getApplicationContext());
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
