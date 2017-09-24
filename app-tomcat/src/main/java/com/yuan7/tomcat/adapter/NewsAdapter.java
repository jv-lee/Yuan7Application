package com.yuan7.tomcat.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.bean.impl.ContentEntity;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.utils.TimeUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */

public class NewsAdapter extends BaseMultiItemQuickAdapter<ContentEntity, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public NewsAdapter(List<ContentEntity> data) {
        super(data);
        addItemType(ContentEntity.MULTI, R.layout.item_news_mult);
        addItemType(ContentEntity.SIGNLE, R.layout.item_news_single);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContentEntity item) {
        switch (helper.getItemViewType()) {
            case ContentEntity.MULTI:
                if (item.getSize() > 0) {
                    GlideImageLoader.loadImage(item.getImages().get(0).getUrl(), (ImageView) helper.getView(R.id.iv_image1));
                }
                if (item.getSize() > 1) {
                    GlideImageLoader.loadImage(item.getImages().get(1).getUrl(), (ImageView) helper.getView(R.id.iv_image2));
                }
                if (item.getSize() > 2) {
                    GlideImageLoader.loadImage(item.getImages().get(2).getUrl(), (ImageView) helper.getView(R.id.iv_image3));
                }
                helper.setText(R.id.tv_timeStr, TimeUtil.getChineseTimeString(item.getEditeTime() == null ? String.valueOf(System.currentTimeMillis()) : item.getEditeTime()))
                        .setText(R.id.tv_title, item.getTitle())
                        .setText(R.id.tv_readCount, String.valueOf(item.getViewTimes()))
                        .setText(R.id.tv_inputCount, String.valueOf(item.getCommentRate()))
                        .setText(R.id.tv_niceCount, String.valueOf(item.getGootRate()));
                break;
            case ContentEntity.SIGNLE:
                if (item.getSize() > 0) {
                    GlideImageLoader.loadImage(item.getImages().get(0).getUrl(), (ImageView) helper.getView(R.id.iv_image));
                }
                helper.setText(R.id.tv_timeStr, TimeUtil.getChineseTimeString(item.getEditeTime() == null ? String.valueOf(System.currentTimeMillis()) : item.getEditeTime()))
                        .setText(R.id.tv_title, item.getTitle())
                        .setText(R.id.tv_readCount, String.valueOf(item.getViewTimes()))
                        .setText(R.id.tv_inputCount, String.valueOf(item.getCommentRate()))
                        .setText(R.id.tv_niceCount, String.valueOf(item.getGootRate()));
                break;
        }
    }
}
