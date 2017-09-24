package com.yuan7.tomcat.utils;

import android.content.Context;
import android.content.Intent;

import com.yuan7.tomcat.bean.impl.ContentEntity;
import com.yuan7.tomcat.bean.impl.ReplyEntity;
import com.yuan7.tomcat.bean.impl.PostEntity;
import com.yuan7.tomcat.constant.Constant;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/11.
 */

public class IntentUtil {

    public static Map<String, Object> getParamsMap(ReplyEntity sendEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.FRAGMENT_TITLE, sendEntity.getNewsTitle() == null ? "" : sendEntity.getNewsTitle());
        map.put(Constant.FRAGMENT_IMAGE, sendEntity.getImages() == null || sendEntity.getImages().size() == 0 ? "" : sendEntity.getImages().get(0).getUrl());
        map.put(Constant.FRAGMENT_CONTENT, sendEntity.getSourceUrl() == null ? "" : sendEntity.getSourceUrl());
        map.put(Constant.FRAGMENT_TYPE, sendEntity.getSourceType());
        map.put(Constant.FRAGMENT_ID, sendEntity.getNewsId());
        return map;
    }

    public static Map<String, Object> getParamsMap(PostEntity sendEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.FRAGMENT_TITLE, sendEntity.getTitle() == null ? "" : sendEntity.getTitle());
        map.put(Constant.FRAGMENT_IMAGE, sendEntity.getImages() == null || sendEntity.getImages().size() == 0 ? "" : sendEntity.getImages().get(0).getUrl());
        map.put(Constant.FRAGMENT_CONTENT, sendEntity.getSourceUrl() == null ? "" : sendEntity.getSourceUrl());
        map.put(Constant.FRAGMENT_TYPE, sendEntity.getSourceType());
        map.put(Constant.FRAGMENT_ID, sendEntity.getId());
        return map;
    }

    public static Map<String, Object> getParamsMap(ContentEntity contentEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.FRAGMENT_TITLE, contentEntity.getTitle() == null ? "" : contentEntity.getTitle());
        map.put(Constant.FRAGMENT_IMAGE, contentEntity.getImages() == null || contentEntity.getImages().size() == 0 ? "" : contentEntity.getImages().get(0).getUrl());
        map.put(Constant.FRAGMENT_CONTENT, contentEntity.getSourceUrl() == null ? "" : contentEntity.getSourceUrl());
        map.put(Constant.FRAGMENT_TYPE, contentEntity.getSourceType());
        map.put(Constant.FRAGMENT_ID, contentEntity.getId());
        return map;
    }

    public static void setParamsIntoActivity(Context packageContext, Class<?> cls, Map<String, Object> params) {
        Intent intent = new Intent(packageContext, cls);
        Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) iterator.next();
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                intent.putExtra(key, (int) value);
            } else if (value instanceof String) {
                intent.putExtra(key, (String) value);
            } else if (value instanceof Boolean) {
                intent.putExtra(key, (Boolean) value);
            }
        }
        packageContext.startActivity(intent);
    }
}
