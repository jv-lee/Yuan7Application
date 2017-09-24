package com.yuan7.tomcat.utils;

import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.bean.impl.SettingsUserEntity;
import com.yuan7.tomcat.bean.impl.UserEntity;

import retrofit2.Response;

/**
 * Created by Administrator on 2017/9/12.
 */

public class SaveUserUtil {

    public static void saveUserSP(SettingsUserEntity entity) {
        SPUtil.save(UserParams.USER_ICON_URL, entity.getObj().getImage());
        SPUtil.save(UserParams.USER_NAME, entity.getObj().getName());
        SPUtil.save(UserParams.USER_SEX, entity.getObj().isSex());
        SPUtil.save(UserParams.USER_BIRTHDAY, entity.getObj().getBirthday());
        SPUtil.save(UserParams.USER_LEVEL, entity.getObj().getLevel());
        SPUtil.save(UserParams.USER_GLOB, (int) entity.getObj().getGlob());
        SPUtil.save(UserParams.USER_LEVEL_NAME, entity.getObj().getLevelname());

    }

    public static void saveUserSP(Response<UserEntity> userEntityResponse) {
        SPUtil.save(UserParams.USER_TOKEN, userEntityResponse.body().getObj().getToken());
        SPUtil.save(UserParams.USER_ID, userEntityResponse.body().getObj().getUser().getId());
        SPUtil.save(UserParams.USER_ICON_URL, userEntityResponse.body().getObj().getUser().getImage());
        SPUtil.save(UserParams.USER_NAME, userEntityResponse.body().getObj().getUser().getName());
        SPUtil.save(UserParams.USER_SEX, userEntityResponse.body().getObj().getUser().isSex());
        SPUtil.save(UserParams.USER_BIRTHDAY, userEntityResponse.body().getObj().getUser().getBirthday());
        SPUtil.save(UserParams.USER_LEVEL, userEntityResponse.body().getObj().getUser().getLevel());
        SPUtil.save(UserParams.USER_GLOB, (int) userEntityResponse.body().getObj().getUser().getGlob());
        SPUtil.save(UserParams.USER_LEVEL_NAME, userEntityResponse.body().getObj().getUser().getLevelname());
    }
}
