package com.yuan7.tomcat.helper;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by Administrator on 2017/9/25.
 */

public class AHelper {
    public static void toEvent(Context context, String id) {
        MobclickAgent.onEvent(context, id);
    }
}
