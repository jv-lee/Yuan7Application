package com.yuan7.tomcat.utils;

import android.content.Context;

/**
 * Created by Administrator on 2017/9/19.
 */

public class AStringUtil {

    public static String format(Context context, int strResourcesId, Object code) {
        String strResources = context.getResources().getString(strResourcesId);
        return String.format(strResources, code);
    }

    public static String format(Context context, int strResourcesId) {
        String strResources = context.getResources().getString(strResourcesId);
        return strResources;
    }
}
