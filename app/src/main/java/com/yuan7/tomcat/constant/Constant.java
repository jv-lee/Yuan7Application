package com.yuan7.tomcat.constant;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Constant {
    //服务地址
//    public static final String BASE_URL = "http://192.168.3.73:9999/";
    public static final String BASE_URL = "http://192.168.3.143:8080/";
    public static final String CONTENT_URL = BASE_URL + "news/detail/";

    //侧滑菜单 启动模式 键值
    public static final String MENU_DATE_TAG = "menu_mode";

    //侧滑菜单 项地址 键值
    public static final String MENU_FRIEND = "friend";
    public static final String MENU_POST = "post";
    public static final String MENU_MESSAGE = "message";
    public static final String MENU_SHOP = "shop";
    public static final String MENU_USER_SETTINGS = "userSettings";
    public static final String MENU_APP_SETTINGS = "appSettings";

    //fragment 类型键名
    public static final String FRAGMENT_TITLE = "title";
    public static final String FRAGMENT_IMAGE = "image";
    public static final String FRAGMENT_CONTENT = "content";
    public static final String FRAGMENT_TYPE = "type";
    public static final String FRAGMENT_ID = "id";
    public static final int FRAGMENT_TYPE_NEW = 1; //最新
    public static final int FRAGMENT_TYPE_GOOD = 2; //精华
    public static final int FRAGMENT_TYPE_HOT = 3; //最热

    //好友类型查询
    public static final int TYPE_FRIEND_LEVEL = 1; //按等级
    public static final int TYPE_FRIEND_SEND = 2; //按发送
    public static final int TYPE_FRIEND_NICE = 3; //按点赞

    //好友参数 键名
    public static final String FRIEND_USER_ID = "user_id";
    public static final String FRIEND_USER_IMAGE = "user_image";
    public static final String FRIEND_USER_NAME = "user_name";
    public static final String FRIEND_USER_LEVEL = "user_level";
    public static final String FRIEND_USER_FRIEND_COUNT = "user_friend_count";
    public static final String FRIEND_USER_SEND_COUNT = "user_send_count";
    public static final String FRIEND_USER_REPLY_COUNT = "user_reply_count";

    //消息类型查询
    public static final int TYPE_MESSAGE_FIND_THIS = 1;//@我的
    public static final int TYPE_MESSAGE_INPUT_THIS = 2;//@评论我的
    public static final int TYPE_MESSAGE_NICE_THIS = 3;//@赞我的


    //RxBus 消息键值
    public static final int RX_BUS_APPBAR_OPEN = 1;//appbar 打开状态 RxBus 通知
    public static final int RX_BUS_APPBAR_CLOSE = 2;//appbar 关闭状态 RxBus 通知
    public static final int RX_BUS_START_FRIEND = 3;//跳转到 好友页面 RxBus 通知
    public static final int RX_BUS_START_MENU = 4; //修改Menu 用户信息


    //上传图片视频 返回code
    public static final int PICTURE_CODE1 = 201;
    public static final int PICTURE_CODE2 = 202;
    public static final int PICTURE_CODE3 = 203;

    //上传文件 类型键名
    public static final String PICTURE_TYPE_IMAGE = "image";
    public static final String PICTURE_TYPE_VIDEO = "video";

    //用户参数上传 键名
    public static final String USER_KEY_IMAGE = "image";
    public static final String USER_KEY_NAME = "name";
    public static final String USER_KEY_LEVEL = "level";
    public static final String USER_KEY_SEX = "sex";
    public static final String USER_KEY_BIRTHDAY = "birthDate";


}
