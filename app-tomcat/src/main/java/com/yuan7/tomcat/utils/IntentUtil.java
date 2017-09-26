package com.yuan7.tomcat.utils;

import android.content.Context;
import android.content.Intent;

import com.yuan7.tomcat.entity.impl.ContentEntity;
import com.yuan7.tomcat.entity.impl.FriendEntity;
import com.yuan7.tomcat.entity.impl.ProductEntity;
import com.yuan7.tomcat.entity.impl.ReplyEntity;
import com.yuan7.tomcat.entity.impl.PostEntity;
import com.yuan7.tomcat.entity.impl.SearchEntity;
import com.yuan7.tomcat.constant.Constant;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/11.
 */

public class IntentUtil {
    public static Map<String, Object> getParamsMap(ContentEntity.User contentEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.FRIEND_USER_ID, contentEntity.getId());
//        map.put(Constant.FRIEND_USER_NAME, contentEntity.getName());
//        map.put(Constant.FRIEND_USER_IMAGE, contentEntity.getImage());
//        map.put(Constant.FRIEND_USER_LEVEL, contentEntity.getLevel());
//        map.put(Constant.FRIEND_USER_LEVEL_NAME, contentEntity.getLevelname());
//        map.put(Constant.FRIEND_USER_SEND_COUNT, contentEntity.getNewsNum());
//        map.put(Constant.FRIEND_USER_REPLY_COUNT, contentEntity.getGoodNum());
//        map.put(Constant.FRIEND_USER_FRIEND_COUNT, 0);
//        map.put(Constant.FRIEND_USER_FRIEND_FLAG, contentEntity.isFriendFlag());
        return map;
    }

    public static Map<String, Object> getParamsMap(FriendEntity contentEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.FRIEND_USER_ID, contentEntity.getId());
//        map.put(Constant.FRIEND_USER_NAME, contentEntity.getName());
//        map.put(Constant.FRIEND_USER_IMAGE, contentEntity.getImage());
//        map.put(Constant.FRIEND_USER_LEVEL, contentEntity.getLevel());
//        map.put(Constant.FRIEND_USER_LEVEL_NAME, contentEntity.getLevelname());
//        map.put(Constant.FRIEND_USER_SEND_COUNT, contentEntity.getNewsNum());
//        map.put(Constant.FRIEND_USER_REPLY_COUNT, contentEntity.getGoodNum());
//        map.put(Constant.FRIEND_USER_FRIEND_COUNT, 0);
//        map.put(Constant.FRIEND_USER_FRIEND_FLAG, contentEntity.isFriendFlag());
        return map;
    }

    /**
     * intent中保存 商品实体信息
     *
     * @param productEntity
     * @return
     */
    public static Map<String, Object> getParamsMap(ProductEntity productEntity) {
        Map<String, Object> map = new HashMap<>();
        StringBuilder urls = new StringBuilder();
        for (int i = 0; i < productEntity.getImages().size(); i++) {
            if (i != 0) {
                urls.append(",");
            }
            urls.append(productEntity.getImages().get(i).getUrl());
        }
        map.put(Constant.PRODUCT_PIC_URLS, urls.toString());
        map.put(Constant.PRODUCT_PIC_URL, productEntity.getPhotos() == null ? "" : productEntity.getPhotos());
        map.put(Constant.PRODUCT_TEXT_CONTENT, productEntity.getDescription() == null ? "" : productEntity.getDescription());
        map.put(Constant.PRODUCT_PRICE, productEntity.getPrice());
        map.put(Constant.PRODUCT_NUM, productEntity.getStock());
        map.put(Constant.PRODUCT_ID, productEntity.getId());
        map.put(Constant.PRODUCT_COUNT, productEntity.getCount());
        return map;
    }

    /**
     * intent 保存回帖实体信息
     *
     * @param replyEntity
     * @return
     */
    public static Map<String, Object> getParamsMap(ReplyEntity replyEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.FRAGMENT_TITLE, replyEntity.getNewsTitle() == null ? "" : replyEntity.getNewsTitle());
        map.put(Constant.FRAGMENT_IMAGE, replyEntity.getImages() == null || replyEntity.getImages().size() == 0 ? "" : replyEntity.getImages().get(0).getUrl());
        map.put(Constant.FRAGMENT_CONTENT, replyEntity.getSourceUrl() == null ? "" : replyEntity.getSourceUrl());
        map.put(Constant.FRAGMENT_TYPE, replyEntity.getSourceType());
        map.put(Constant.FRAGMENT_ID, replyEntity.getNewsId());
        return map;
    }

    /**
     * intent 保存 发帖实体信息
     *
     * @param sendEntity
     * @return
     */
    public static Map<String, Object> getParamsMap(PostEntity sendEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.FRAGMENT_TITLE, sendEntity.getTitle() == null ? "" : sendEntity.getTitle());
        map.put(Constant.FRAGMENT_IMAGE, sendEntity.getImages() == null || sendEntity.getImages().size() == 0 ? "" : sendEntity.getImages().get(0).getUrl());
        map.put(Constant.FRAGMENT_CONTENT, sendEntity.getSourceUrl() == null ? "" : sendEntity.getSourceUrl());
        map.put(Constant.FRAGMENT_TYPE, sendEntity.getSourceType());
        map.put(Constant.FRAGMENT_ID, sendEntity.getId());
        return map;
    }

    public static Map<String, Object> getParamsMap(SearchEntity contentEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.FRAGMENT_TITLE, contentEntity.getTitle() == null ? "" : contentEntity.getTitle());
        map.put(Constant.FRAGMENT_IMAGE, contentEntity.getImages() == null || contentEntity.getImages().size() == 0 ? "" : contentEntity.getImages().get(0).getUrl());
        map.put(Constant.FRAGMENT_CONTENT, contentEntity.getSourceUrl() == null ? "" : contentEntity.getSourceUrl());
        map.put(Constant.FRAGMENT_TYPE, contentEntity.getSourceType());
        map.put(Constant.FRAGMENT_ID, contentEntity.getId());
        map.put(Constant.FRAGMENT_AD, false);
        return map;
    }

    /**
     * intent 保存 内容实体信息
     *
     * @param contentEntity
     * @return
     */
    public static Map<String, Object> getParamsMap(ContentEntity contentEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.FRAGMENT_TITLE, contentEntity.getTitle() == null ? "" : contentEntity.getTitle());
        map.put(Constant.FRAGMENT_IMAGE, contentEntity.getImages() == null || contentEntity.getImages().size() == 0 ? "" : contentEntity.getImages().get(0).getUrl());
        map.put(Constant.FRAGMENT_CONTENT, contentEntity.getSourceUrl() == null ? "" : contentEntity.getSourceUrl());
        map.put(Constant.FRAGMENT_TYPE, contentEntity.getSourceType());
        map.put(Constant.FRAGMENT_ID, contentEntity.getId());
        map.put(Constant.FRAGMENT_AD, false);
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
            } else if (value instanceof Double) {
                intent.putExtra(key, (Double) value);
            }
        }
        packageContext.startActivity(intent);
    }
}
