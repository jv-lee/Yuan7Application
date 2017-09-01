package com.yuan7.tomcat.adapter;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.video.lib.VideoPlayerStandard;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.AQEntity;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */

public class AQAdapter extends BaseMultiItemQuickAdapter<AQEntity, BaseViewHolder> {

    public AQAdapter(@Nullable List<AQEntity> data) {
        super(data);
        addItemType(AQEntity.IMAGE,R.layout.item_aq_image);
        addItemType(AQEntity.VIDEO,R.layout.item_aq_video);
    }

    @Override
    protected void convert(BaseViewHolder helper, AQEntity item) {
        GlideImageLoader.loadImage(mContext, item.getIconUrl(), (ImageView) helper.getView(R.id.iv_icon));
        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_timeStr, item.getDateStr())
                .setText(R.id.tv_level,"lv:"+item.getLevel())
                .setText(R.id.tv_levelStr,item.getLevelStr())
                .setText(R.id.tv_goldCount, "悬赏  " + item.getGoldCount())
                .setText(R.id.tv_contentMessage, item.getContentMessage())
                .setText(R.id.tv_readCount, String.valueOf(item.getReadCount()))
                .setText(R.id.tv_inputCount, String.valueOf(item.getInputCount()))
                .setText(R.id.tv_niceCount, String.valueOf(item.getNiceCount()));

        switch (helper.getItemViewType()) {
            case AQEntity.IMAGE:
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
                break;
            case AQEntity.VIDEO:
                if (null != item.getVideoUrl() && null != item.getVideoPic() && null != item.getVideoTitle()) {
                    VideoPlayerStandard videoView = helper.getView(R.id.videoView);
                    if (videoView != null) {
                        videoView.setUp(item.getVideoUrl(), VideoPlayerStandard.SCREEN_LAYOUT_LIST, item.getVideoTitle());
                        GlideImageLoader.loadImage(mContext, item.getVideoPic(), videoView.thumbImageView);
                    }

                }
                break;
        }

    }
}
