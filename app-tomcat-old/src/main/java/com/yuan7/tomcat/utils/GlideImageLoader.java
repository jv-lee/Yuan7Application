package com.yuan7.tomcat.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.jv.bannerlib.loader.ImageLoader;
import com.yuan7.tomcat.R;

/**
 * Created by Administrator on 2017/2/28.
 */

public class GlideImageLoader extends ImageLoader {

    private static RequestOptions optionsSimple = null;
    private static RequestOptions options = null;
    private static DrawableTransitionOptions transitionOptions = null;

    public static void initOptions(){
        if (optionsSimple == null) {
            optionsSimple = new RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH);
        }

        if (options == null) {
            options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.ic_photo)
                    .error(R.drawable.ic_photo)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH);
        }

        if (transitionOptions == null) {
            transitionOptions = new DrawableTransitionOptions();
            transitionOptions.crossFade();
        }
    }

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        initOptions();

        /**
         注意：
         1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
         2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
         传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
         切记不要胡乱强转！
         */
        //Glide 加载图片简单用法
        Glide.with(context)
                .load(path)
                .apply(optionsSimple)
                .transition(transitionOptions)
                .into(imageView);
    }

    public static void loadImage(Context context, Object path, ImageView imageView) {

        initOptions();

        /**
         注意：
         1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
         2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
         传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
         切记不要胡乱强转！
         */
        //Glide 加载图片简单用法
        Glide.with(context)
                .load(path)
                .apply(options)
                .transition(transitionOptions)
                .into(imageView);
    }
}
