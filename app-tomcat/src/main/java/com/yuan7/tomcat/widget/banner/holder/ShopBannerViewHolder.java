package com.yuan7.tomcat.widget.banner.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yuan7.tomcat.bean.impl.ProductEntity;
import com.yuan7.tomcat.entity.ShopBannerEntity;
import com.yuan7.tomcat.helper.GlideImageLoader;

/**
 * Created by Administrator on 2017/8/15.
 */

public class ShopBannerViewHolder implements MZViewHolder<ProductEntity> {
    private ImageView mImageView;

    @Override
    public View createView(Context context) {
        mImageView = new ImageView(context);
        mImageView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return mImageView;
    }

    @Override
    public void onBind(Context context, int position, ProductEntity data) {
        GlideImageLoader.loadImage(data.getPhotos(), mImageView);
    }

}
