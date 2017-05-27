package com.yuan7.tomcat.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yuan7.tomcat.Config;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.bean.impl.BannerBean;
import com.yuan7.tomcat.bean.impl.NewsBean;
import com.yuan7.tomcat.bean.impl.ProPagateBean;
import com.yuan7.tomcat.bean.impl.RaidersBean;
import com.yuan7.tomcat.bean.impl.RecommendBean;
import com.yuan7.tomcat.bean.impl.VideoBean;
import com.yuan7.tomcat.ui.content.app.AppDataActivity;
import com.yuan7.tomcat.ui.content.raiders.RaidersDataActivity;
import com.yuan7.tomcat.ui.content.video.VideoDataActivity;

import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Ly on 2017/5/4.
 * 通用工具类
 */

public class Helper {

    public static void startContentActivity(Context context, Object bean) {
        if (bean instanceof NewsBean.ResultBean) {
            NewsBean.ResultBean newsBean = (NewsBean.ResultBean) bean;
            toTypeActivity(context, newsBean.getType(), newsBean.getContentUrl(), newsBean.getVedioUrl(), newsBean.getId() + "", newsBean.getTitle(), newsBean.getImgUrl(), newsBean.getAppName());
        } else if (bean instanceof BannerBean.ResultBean) {
            BannerBean.ResultBean bannerBean = (BannerBean.ResultBean) bean;
            toTypeActivity(context, bannerBean.getType(), bannerBean.getContentUrl(), bannerBean.getVedioUrl(), bannerBean.getId() + "", bannerBean.getTitle(), bannerBean.getImgUrl(), bannerBean.getAppName());
        } else if (bean instanceof ProPagateBean.ResultBean) {
            ProPagateBean.ResultBean proBean = (ProPagateBean.ResultBean) bean;
            toTypeActivity(context, proBean.getType(), proBean.getContentUrl(), proBean.getVedioUrl(), proBean.getId(), proBean.getTitle(), proBean.getImgUrl(), proBean.getAppName());
        } else if (bean instanceof RaidersBean.ResultBean) {
            RaidersBean.ResultBean raidersBean = (RaidersBean.ResultBean) bean;
            toTypeActivity(context, raidersBean.getType(), raidersBean.getContentUrl(), raidersBean.getVedioUrl(), raidersBean.getId() + "", raidersBean.getTitle(), raidersBean.getImgUrl(), raidersBean.getAppName());
        } else if (bean instanceof VideoBean.ResultBean) {
            VideoBean.ResultBean videoBean = (VideoBean.ResultBean) bean;
            toTypeActivity(context, videoBean.getType(), videoBean.getContentUrl(), videoBean.getVedioUrl(), videoBean.getId(), videoBean.getTitle(), videoBean.getImgUrl(), videoBean.getAppName());
        } else if (bean instanceof RecommendBean.ResultBean) {
            RecommendBean.ResultBean recommendBean = (RecommendBean.ResultBean) bean;
            toTypeActivity(context, recommendBean.getType(), recommendBean.getContentUrl(), recommendBean.getVedioUrl(), recommendBean.getId() + "", recommendBean.getTitle(), recommendBean.getImgUrl(), recommendBean.getAppName());
        }

    }

    public static void toTypeActivity(Context context, String type, String contentUrl, String apiUrl, String id, String title, String image, String apkPackage) {
        Log.i("Helper contentUrl->", contentUrl);
        Log.i("Helper apiUrl->", apiUrl);
        Log.i("Helper id->", id);
        switch (type) {
            case Config.TYPE_NEWS:
                context.startActivity(new Intent(context, RaidersDataActivity.class).putExtra("contentUrl", ServiceModule.BASE_URL + contentUrl));
                break;
            case Config.TYPE_VIDEO:
                context.startActivity(new Intent(context, VideoDataActivity.class).putExtra("contentUrl", ServiceModule.BASE_URL + contentUrl).putExtra("apiUrl", ServiceModule.BASE_URL + apiUrl).putExtra("title", title).putExtra("imageUrl", ServiceModule.BASE_URL + image));
                break;
            case Config.TYPE_APP:
                context.startActivity(new Intent(context, AppDataActivity.class).putExtra("id", id).putExtra("apkPackage", apkPackage));
                break;
        }
    }

    /**
     * B 转mb
     *
     * @param size
     * @return
     */
    public static String getPrintSize(long size) {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        //因为还没有到达要使用另一个单位的时候
        //接下去以此类推
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //因为如果以MB为单位的话，要保留最后1位小数，
            //因此，把此数乘以100之后再取余
            size = size * 100;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "MB";
        } else {
            //否则如果要以GB为单位的，先除于1024再作同样的处理
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "GB";
        }
    }

    /**
     * 获取进度
     *
     * @param completed
     * @param total
     * @return
     */
    public static String getPercent(long completed, long total) {

        if (total > 0) {
            double fen = ((double) completed / (double) total) * 100;
            DecimalFormat df1 = new DecimalFormat("0");
            return df1.format(fen);
        }
        return "0";
    }

    public static String getCurrentTimeZone() {
        TimeZone tz = TimeZone.getDefault();
        return createGmtOffsetString(true, true, tz.getRawOffset());
    }

    public static String createGmtOffsetString(boolean includeGmt,
                                               boolean includeMinuteSeparator, int offsetMillis) {
        int offsetMinutes = offsetMillis / 60000;
        char sign = '+';
        if (offsetMinutes < 0) {
            sign = '-';
            offsetMinutes = -offsetMinutes;
        }
        StringBuilder builder = new StringBuilder(9);
        if (includeGmt) {
            builder.append("GMT");
        }
        builder.append(sign);
        appendNumber(builder, 2, offsetMinutes / 60);
        if (includeMinuteSeparator) {
            builder.append(':');
        }
        appendNumber(builder, 2, offsetMinutes % 60);
        return builder.toString();
    }

    private static void appendNumber(StringBuilder builder, int count, int value) {
        String string = Integer.toString(value);
        for (int i = 0; i < count - string.length(); i++) {
            builder.append('0');
        }
        builder.append(string);
    }

    /**
     * 获取当前文件夹下 文件集合
     *
     * @param context
     * @return
     */
    public static String readApk(Context context, String apkPackage) {
        File file;
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.y7app/download");
        if (!file.exists()) {
            file.mkdir();
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (readFilePackage(context, files[i].getAbsolutePath()).equals(apkPackage)) {
                    return files[i].getAbsolutePath();
                }
            }
        }
        //未下载
        return null;
    }

    public static int readAppPathCode(Context context, String apkPackage) {
        if (hasInstalled(context, apkPackage)) {
            return 1; //已经安装 直接打开
        } else {
            return 2; //未安装 点击安装
        }
    }

    /**
     * 根据文件路径 读取apk文件 获取文件包名信息
     *
     * @param context
     * @param path
     * @return
     */
    public static String readFilePackage(Context context, String path) {
        String packageName = null;
        PackageManager pm = context.getPackageManager();
        PackageInfo info = pm.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES);
        ApplicationInfo appInfo = null;
        if (info != null) {
            appInfo = info.applicationInfo;
            packageName = appInfo.packageName;
        }
        return packageName;
    }

    /**
     * 检测是否安装过
     *
     * @param context 调用的句柄
     * @param pkgName 包名
     * @return boolean
     */
    public static boolean hasInstalled(Context context, String pkgName) {
        try {
            PackageManager pm = context.getPackageManager();
            List<ApplicationInfo> list = pm.getInstalledApplications(0);
            for (ApplicationInfo info : list) {
                if (info.packageName.equals(pkgName))
                    return true;
            }
        } catch (Exception e) {
            Log.w("TAG", "hasInstalled error = " + e);
        }
        return false;
    }


    /**
     * 根据文件地址 打开该文件安装
     *
     * @param context
     * @param apkPath
     */
    public static void openInstallApp(Context context, String apkPath) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://" + apkPath), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 根据文件地址 获取apk包名 打开 apk
     *
     * @param context
     * @param apkPackage
     */
    public static void openApp(Context context, String apkPackage) {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(apkPackage));
    }

}
