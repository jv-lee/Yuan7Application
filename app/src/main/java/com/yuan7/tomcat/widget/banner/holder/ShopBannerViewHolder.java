package com.yuan7.tomcat.widget.banner.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yuan7.tomcat.entity.BannerEntity;
import com.yuan7.tomcat.entity.ShopBannerEntity;
import com.yuan7.tomcat.utils.GlideImageLoader;

/**
 * Created by Administrator on 2017/8/15.
 */

public class ShopBannerViewHolder implements MZViewHolder<ShopBannerEntity> {
    private ImageView mImageView;

    @Override
    public View createView(Context context) {
        mImageView = new ImageView(context);
        mImageView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return mImageView;
    }

    @Override
    public void onBind(Context context, int position, ShopBannerEntity data) {
        GlideImageLoader.loadImage(context, data.getImageUrl(), mImageView);
    }
}
