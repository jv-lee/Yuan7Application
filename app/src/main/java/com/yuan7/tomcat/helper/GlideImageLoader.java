package com.yuan7.tomcat.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.yuan7.tomcat.R;

import java.io.ByteArrayOutputStream;

/**
 * Created by Administrator on 2017/8/15.
 */

public class GlideImageLoader {

    private volatile static GlideImageLoader mInstance = null;

    private static Context mContext = null;

    private static RequestOptions optionsCommand = null;
    private static DrawableTransitionOptions OptionsDrawable = null;
    private static RequestOptions optionsCircleCrop = null;

    private GlideImageLoader() {
        initOptions();
    }

    public static GlideImageLoader getInstance(Context context) {
        if (mInstance == null) {
            synchronized (GlideImageLoader.class) {
                if (mInstance == null) {
                    mContext = context;
                    mInstance = new GlideImageLoader();
                }
            }
        }
        return mInstance;
    }

    private void initOptions() {
        //初始化普通加载
        if (optionsCommand == null) {
            optionsCommand = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.ic_photo_white_56dp)
                    .error(R.drawable.ic_photo_white_56dp)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH);
        }

        //初始化动画加载
        if (OptionsDrawable == null) {
            OptionsDrawable = new DrawableTransitionOptions();
            OptionsDrawable.crossFade();
        }

        //初始化圆形图加载
        if (optionsCircleCrop == null) {
            optionsCircleCrop = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.ic_photo_white_56dp)
                    .error(R.drawable.ic_photo_white_56dp)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .transform(new GlideCircleTransform());
        }

    }

    public static void loadImage(Object path, ImageView imageView) {
        Glide.with(mContext)
                .load(path)
                .transition(OptionsDrawable)
                .apply(optionsCommand)
                .into(imageView);
    }

    public static void loadCircleCrop(Object path, ImageView imageView) {
        Glide.with(mContext)
                .load(path)
                .transition(OptionsDrawable)
                .apply(optionsCircleCrop)
                .into(imageView);
    }


}
