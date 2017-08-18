package com.yuan7.tomcat.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.VideoEntity;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */

public class VideoAdapter extends BaseQuickAdapter<VideoEntity, BaseViewHolder> {
    public VideoAdapter(@Nullable List<VideoEntity> data) {
        super(R.layout.item_video, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoEntity item) {
        GlideImageLoader.loadImage(mContext, item.getImageUrl(), (ImageView) helper.getView(R.id.iv_image));
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_content, item.getContent())
                .setText(R.id.tv_inputCount, "评论(" + item.getInputCount() + ")")
                .setText(R.id.tv_niceCount, "点赞(" + item.getNiceCount() + ")");
    }
}
