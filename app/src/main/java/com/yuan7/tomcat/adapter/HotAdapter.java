package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.HotEntity;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */

public class HotAdapter extends BaseQuickAdapter<HotEntity, BaseViewHolder> {

    public HotAdapter(@Nullable List<HotEntity> data) {
        super(R.layout.item_hot, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HotEntity item) {
        GlideImageLoader.loadImage(mContext, item.getImageUrl(), (ImageView) helper.getView(R.id.iv_image));
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_timeStr, item.getTimeStr())
                .setText(R.id.tv_readCount, String.valueOf(item.getReadCount()))
                .setText(R.id.tv_inputCount, String.valueOf(item.getInputCount()))
                .setText(R.id.tv_niceCount, String.valueOf(item.getNiceCount()));
    }
}
