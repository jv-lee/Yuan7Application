package com.yuan7.tomcat.constant;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Constant {
    //服务地址
//    public static String BASE_URL = SERVER_URL;
    public static final String BASE_URL = "http://120.25.82.88:8484/";
    //        public static String BASE_URL = "http://192.168.3.73:9999/";
//    public static final String TEST_URL = "http://192.168.3.80:8080/";
    //    public static final String BASE_URL = "http://192.168.3.143:8080/";
    public static final String CONTENT_URL = BASE_URL + "news/detail/";
    public static final String ACTIVI_URL = BASE_URL + "signin/home";

    //侧滑菜单 启动模式 键值
    public static final String MENU_DATE_TAG = "menu_mode";

    //侧滑菜单 项地址 键值
    public static final String MENU_FRIEND = "friend";
    public static final String MENU_POST = "post";
    public static final String MENU_MESSAGE = "message";
    public static final String MENU_SHOP = "shop";
    public static final String MENU_RECORD = "record";
    public static final String MENU_USER_SETTINGS = "userSettings";
    public static final String MENU_APP_SETTINGS = "appSettings";
    public static final String MENU_CODE = "code";
    public static final String MENU_AD = "ad";

    //fragment 类型键名
    public static final String FRAGMENT_TITLE = "title";
    public static final String FRAGMENT_IMAGE = "image";
    public static final String FRAGMENT_CONTENT = "content";
    public static final String FRAGMENT_TYPE = "type";
    public static final String FRAGMENT_ID = "id";
    public static final String FRAGMENT_AD = "ad";
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
    public static final String FRIEND_USER_LEVEL_NAME = "user_level_name";
    public static final String FRIEND_USER_FRIEND_COUNT = "user_friend_count";
    public static final String FRIEND_USER_SEND_COUNT = "user_send_count";
    public static final String FRIEND_USER_REPLY_COUNT = "user_reply_count";
    public static final String FRIEND_USER_FRIEND_FLAG = "user_friend_flag";

    //消息类型查询
    public static final int TYPE_MESSAGE_FIND_THIS = 1;//@我的
    public static final int TYPE_MESSAGE_INPUT_THIS = 2;//@评论我的
    public static final int TYPE_MESSAGE_NICE_THIS = 3;//@赞我的


    //RxBus 消息键值
    public static final int RX_BUS_APPBAR_OPEN = 1;//appbar 打开状态 RxBus 通知
    public static final int RX_BUS_APPBAR_CLOSE = 2;//appbar 关闭状态 RxBus 通知
    public static final int RX_BUS_START_FRIEND = 3;//跳转到 好友页面 RxBus 通知
    public static final int RX_BUS_START_MENU = 4; //修改Menu 用户信息
    public static final int RX_BUS_START_UNLOGIN = 5; //退出登陆
    public static final int RX_BUS_PRODUCT_ADDRESS = 6; //发送 地址信息 状态通知更新页面
    public static final int RX_BUS_START_ICON = 7; //修改Menu 用户头像


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

    //商品信息键名
    public static final String PRODUCT_PIC_URLS = "product_pic_urls";
    public static final String PRODUCT_PIC_URL = "product_pic_url";
    public static final String PRODUCT_TEXT_CONTENT = "product_text_content";
    public static final String PRODUCT_PRICE = "product_price";
    public static final String PRODUCT_NUM = "product_num";
    public static final String PRODUCT_ID = "product_id";
    public static final String PRODUCT_COUNT = "product_count";

    //用户地址信息 键名
    public static final String ADDRESS = "address";
    public static final String ADDRESS_LINKMAN = "linkman";
    public static final String ADDRESS_PHONE_NUMBER = "phone_number";
    public static final String ADDRESS_PROVINCE = "province";
    public static final String ADDRESS_CITY = "city";
    public static final String ADDRESS_COUNTY = "county";
    public static final String ADDRESS_STREET = "street";
    public static final String ADDRESS_DES = "address_des";
    public static final String ADDRESS_FLAG = "address_flag";

}
