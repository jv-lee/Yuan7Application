package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.bean.impl.ProductEntity;
import com.yuan7.tomcat.helper.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */

public class ShopAdapter extends BaseQuickAdapter<ProductEntity, BaseViewHolder> {

    public ShopAdapter(@Nullable List<ProductEntity> data) {
        super(R.layout.item_shop, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductEntity item) {
        GlideImageLoader.loadImage(item.getPhotos(), (ImageView) helper.getView(R.id.iv_image));
        helper.setText(R.id.tv_shopName, item.getTitle())
                .setText(R.id.tv_shopPrice, item.getPrice() + "金币");
    }
}
