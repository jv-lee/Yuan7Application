package com.yuan7.tomcat.helper;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.qq.e.ads.banner.ADSize;
import com.qq.e.ads.banner.AbstractBannerADListener;
import com.qq.e.ads.banner.BannerView;
import com.qq.e.ads.interstitial.AbstractInterstitialADListener;
import com.qq.e.ads.interstitial.InterstitialAD;
import com.umeng.analytics.MobclickAgent;
import com.yuan7.tomcat.R;

/**
 * Created by Administrator on 2017/9/25.
 */

public class AHelper {
    public static void toEvent(Context context, String id) {
        MobclickAgent.onEvent(context, id);
    }

    public static void showS(Activity activity) {
        final InterstitialAD iad = new InterstitialAD(activity, activity.getString(R.string.gdt_appId), activity.getString(R.string.gdt_chaping_id));
        iad.setADListener(new AbstractInterstitialADListener() {

            @Override
            public void onADReceive() {
                iad.show();
            }

            @Override
            public void onNoAD(int arg0) {
            }

        });
//请求插屏广告，每次重新请求都可以调用此方法。
        iad.loadAD();
    }

    public static void showB(Activity activity) {
        BannerView banner = new BannerView(activity, ADSize.BANNER, activity.getString(R.string.gdt_appId), activity.getString(R.string.gdt_banner_id));
        //设置广告轮播时间，为0或30~120之间的数字，单位为s,0标识不自动轮播
        banner.setRefresh(30);
        banner.setADListener(new AbstractBannerADListener() {

            @Override
            public void onNoAD(int arg0) {
            }

            @Override
            public void onADReceiv() {
            }
        });
        /* 发起广告请求，收到广告数据后会展示数据   */
        FrameLayout.LayoutParams bannerLayout = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.FILL_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        bannerLayout.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        if (banner != null) {
            activity.addContentView(banner, bannerLayout);
        }

        banner.loadAD();
    }
}
