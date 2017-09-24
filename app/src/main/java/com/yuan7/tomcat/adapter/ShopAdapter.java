package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.bean.impl.ProdouctEntity;
import com.yuan7.tomcat.entity.ShopEntity;
import com.yuan7.tomcat.helper.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */

public class ShopAdapter extends BaseQuickAdapter<ProdouctEntity, BaseViewHolder> {

    public ShopAdapter(@Nullable List<ProdouctEntity> data) {
        super(R.layout.item_shop, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProdouctEntity item) {
        GlideImageLoader.loadImage(item.getPhotos(), (ImageView) helper.getView(R.id.iv_image));
        helper.setText(R.id.tv_shopName, item.getTitle())
                .setText(R.id.tv_shopPrice, item.getPrice() + "金币");
    }
}
