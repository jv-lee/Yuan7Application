package com.yuan7.tomcat;


/**
 * Created by Administrator on 2017/5/18.
 */

public class Config {
    public static final String TYPE_NEWS = "1";
    public static final String TYPE_VIDEO = "2";
    public static final String TYPE_APP = "3";

    public static int homePageNo = 1;
    public static int videoPageNo = 1;
    public static int raidersPageNo = 1;
    public static int recommendPageNo = 1;

    /**
     * "isOpen": "0"//0关闭，1开启
     */
    private static final String OPEN_TAG = "1";
    private static final String CLOSE_TAG = "0";

    // app Id
    public static final String APP_ID = "4";

    public static String getOpenTag() {
        return OPEN_TAG;
    }

    public static String getCloseTag() {
        return CLOSE_TAG;
    }

    public static String TAB_TAG = "1";

}
