package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.impl.ContentEntity;
import com.yuan7.tomcat.helper.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */

public class VideoAdapter extends BaseQuickAdapter<ContentEntity, BaseViewHolder> {
    public VideoAdapter(@Nullable List<ContentEntity> data) {
        super(R.layout.item_video, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContentEntity item) {
        if (item.getImages().size() > 0) {
            GlideImageLoader.loadImage(item.getImages().get(0).getUrl(), (ImageView) helper.getView(R.id.iv_image));
        }
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_readCount, String.valueOf(item.getViewTimes()))
                .setText(R.id.tv_inputCount, String.valueOf(item.getCommentRate()))
                .setText(R.id.tv_niceCount, String.valueOf(item.getGootRate()));
    }
}
