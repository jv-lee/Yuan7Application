package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.ShopEntity;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */

public class ShopAdapter extends BaseQuickAdapter<ShopEntity,BaseViewHolder>{

    public ShopAdapter(@Nullable List<ShopEntity> data) {
        super(R.layout.item_shop, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopEntity item) {
        GlideImageLoader.loadImage(mContext,item.getImageUrl(), (ImageView) helper.getView(R.id.iv_image));
        helper.setText(R.id.tv_shopName, item.getTitle())
                .setText(R.id.tv_shopPrice, item.getPrice() + "金币");
    }
}
