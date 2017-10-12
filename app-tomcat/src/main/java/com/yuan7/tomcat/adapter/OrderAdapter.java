package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.impl.ProductOrderEntity;
import com.yuan7.tomcat.helper.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class OrderAdapter extends BaseQuickAdapter<ProductOrderEntity, BaseViewHolder> {

    public OrderAdapter(@Nullable List<ProductOrderEntity> data) {
        super(R.layout.item_order, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductOrderEntity item) {
        if (item.getCommodityDetail().size() > 0) {
            ProductOrderEntity.CommodityDetailBean entity = item.getCommodityDetail().get(0);
            GlideImageLoader.loadCircleCrop(entity.getPhotos(), (ImageView) helper.getView(R.id.iv_picture));
            helper.setText(R.id.tv_title, entity.getTitle())
                    .setText(R.id.tv_put_money, "消费" + String.valueOf(entity.getPrice() * entity.getCount()) + "金币")
                    .setText(R.id.tv_dateStr, entity.getCreatTime());
        }
    }
}
