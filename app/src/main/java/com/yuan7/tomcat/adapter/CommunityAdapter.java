package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.video.lib.VideoPlayerStandard;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.bean.impl.ContentEntity;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.utils.TimeUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */

public class CommunityAdapter extends BaseMultiItemQuickAdapter<ContentEntity, BaseViewHolder> {
    public CommunityAdapter(@Nullable List<ContentEntity> data) {
        super(data);
        addItemType(ContentEntity.SIGNLE, R.layout.item_community_image);
        addItemType(ContentEntity.MULTI, R.layout.item_community_image);
        addItemType(ContentEntity.COMM_VIDEO, R.layout.item_community_video);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContentEntity item) {
        if (item.getImages().size() > 0) {

        }
//        GlideImageLoader.loadImage(mContext, item.getIconUrl(), (ImageView) helper.getView(R.id.iv_icon));
        helper.setText(R.id.tv_name, item.getAuthor())
                .setText(R.id.tv_timeStr, TimeUtil.getChineseTimeMill(item.getCreatTime()))
//                .setText(R.id.tv_level, "lv:" + item.getLevel())
//                .setText(R.id.tv_levelStr, item.getLevelStr())
                .setText(R.id.tv_contentMessage, item.getBriefIntroduction())
                .setText(R.id.tv_readCount, String.valueOf(item.getViewTimes()))
                .setText(R.id.tv_inputCount, String.valueOf(item.getCommentRate()))
                .setText(R.id.tv_niceCount, String.valueOf(item.getGootRate()));
        if (helper.getItemViewType() == ContentEntity.MULTI || helper.getItemViewType() == ContentEntity.SIGNLE) {
            if (null != item.getImages()) {
                if (item.getImages().size() == 1) {
                    GlideImageLoader.loadImage(item.getImages().get(0), (ImageView) helper.getView(R.id.iv_image1));
                }
                if (item.getImages().size() == 2) {
                    GlideImageLoader.loadImage(item.getImages().get(1), (ImageView) helper.getView(R.id.iv_image2));
                }
                if (item.getImages().size() > 3) {
                    GlideImageLoader.loadImage(item.getImages().get(2), (ImageView) helper.getView(R.id.iv_image3));
                }
            }
        } else if (helper.getItemViewType() == ContentEntity.COMM_VIDEO) {
            if (null != item.getSourceUrl() && null != item.getImages() && null != item.getTitle()) {
                VideoPlayerStandard videoView = helper.getView(R.id.videoView);
                if (videoView != null) {
                    videoView.setUp(item.getSourceUrl(), VideoPlayerStandard.SCREEN_LAYOUT_LIST, item.getTitle());
                    if (item.getImages() != null && item.getImages().size() > 0) {
                        GlideImageLoader.loadImage(item.getImages().get(0), videoView.thumbImageView);
                    }
                }
            }
        }

    }
}
