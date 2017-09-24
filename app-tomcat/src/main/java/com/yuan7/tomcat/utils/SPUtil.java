package com.yuan7.tomcat.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by jv.lee on 2016/8/31.
 */
public class SPUtil {

    private static final String SP_NAME = "share_data";
    private volatile static SharedPreferences mSharedPreferences;

    private SPUtil() {
    }

    public static SharedPreferences getInstance(Context context) {
        if (mSharedPreferences == null) {
            synchronized (SPUtil.class) {
                if (mSharedPreferences == null) {
                    mSharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_MULTI_PROCESS);
                }
            }
        }
        return mSharedPreferences;
    }


    /**
     * 保存数据 根据数据类型自动拆箱
     *
     * @param key    键名
     * @param values Object类型数据 但仅限于(String/int/float/boolean/long)
     */
    public static void save(String key, Object values) {
        Editor editor = mSharedPreferences.edit();
        if (values instanceof String) {
            editor.putString(key, (String) values);

        } else if (values instanceof Integer) {
            editor.putInt(key, (Integer) values);

        } else if (values instanceof Long) {
            editor.putLong(key, (Long) values);

        } else if (values instanceof Boolean) {
            editor.putBoolean(key, (Boolean) values);

        } else if (values instanceof Float) {
            editor.putFloat(key, (Float) values);
        }
        editor.commit();
    }

    /**
     * 获取Object类型数据 根据接收类型自动拆箱
     *
     * @param key          键名
     * @param defaultValue 根据key获取不到是默认值仅限于(String/int/float/boolean/long)
     */
    public static Object get(String key, Object defaultValue) {
        SharedPreferences sp = mSharedPreferences;
        if (defaultValue instanceof String)
            return sp.getString(key, (String) defaultValue);

        else if (defaultValue instanceof Integer)
            return sp.getInt(key, (Integer) defaultValue);

        else if (defaultValue instanceof Long)
            return sp.getLong(key, (Long) defaultValue);

        else if (defaultValue instanceof Boolean)
            return sp.getBoolean(key, (Boolean) defaultValue);

        else if (defaultValue instanceof Float)
            return sp.getFloat(key, (Float) defaultValue);

        return null;
    }

}
