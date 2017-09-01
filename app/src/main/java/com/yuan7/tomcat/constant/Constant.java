package com.yuan7.tomcat.constant;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Constant {

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
    public static final String FRAGMENT_CONTENT = "content";
    public static final String FRAGMENT_TYPE = "type";
    public static final String FRAGMENT_TYPE_NEW = "new";
    public static final String FRAGMENT_TYPE_GOOD = "good";
    public static final String FRAGMENT_TYPE_HOT = "hot";

    //RxBus 消息键值
    public static final int RX_BUS_APPBAR_OPEN = 1;//appbar 打开状态 RxBus 通知
    public static final int RX_BUS_APPBAR_CLOSE = 2;//appbar 关闭状态 RxBus 通知
    public static final int RX_BUS_START_FRIEND = 3;//跳转到 好友页面 RxBus 通知



}
