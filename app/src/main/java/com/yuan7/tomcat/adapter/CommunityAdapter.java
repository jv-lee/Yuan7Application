package com.yuan7.tomcat.adapter;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.CommunityEntity;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */

public class CommunityAdapter extends BaseQuickAdapter<CommunityEntity, BaseViewHolder> {
    public CommunityAdapter(@Nullable List<CommunityEntity> data) {
        super(R.layout.item_community, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommunityEntity item) {
        GlideImageLoader.loadImage(mContext, item.getIconUrl(), (ImageView) helper.getView(R.id.iv_icon));
        if (null != item.getImageUrls()) {
            if (item.getImageUrls().length > 0) {
                GlideImageLoader.loadImage(mContext, item.getImageUrls()[0], (ImageView) helper.getView(R.id.iv_image1));
            }
            if (item.getImageUrls().length > 1) {
                GlideImageLoader.loadImage(mContext, item.getImageUrls()[1], (ImageView) helper.getView(R.id.iv_image2));
            }
            if (item.getImageUrls().length > 2) {
                GlideImageLoader.loadImage(mContext, item.getImageUrls()[2], (ImageView) helper.getView(R.id.iv_image3));
            }
        }
        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_timeStr, item.getDateStr())
                .setText(R.id.tv_deviceSource, item.getDeviceSource())
                .setText(R.id.tv_contentMessage, item.getContentMessage())
                .setText(R.id.tv_readCount, "浏览量:" + item.getReadCount())
                .setText(R.id.tv_inputCount, String.valueOf(item.getInputCount()))
                .setText(R.id.tv_niceCount, String.valueOf(item.getNiceCount()));
        helper.setChecked(R.id.cb_follow, item.isFollowFlag());
    }
}
