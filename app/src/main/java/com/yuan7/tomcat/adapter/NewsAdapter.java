package com.yuan7.tomcat.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.NewsEntity;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */

public class NewsAdapter extends BaseMultiItemQuickAdapter<NewsEntity, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public NewsAdapter(List<NewsEntity> data) {
        super(data);
        addItemType(NewsEntity.MULTI, R.layout.item_news_mult);
        addItemType(NewsEntity.SIGNLE, R.layout.item_news_single);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsEntity item) {
        switch (helper.getItemViewType()) {
            case NewsEntity.MULTI:
                if (null != item.getImageUrls()[0]) {
                    GlideImageLoader.loadImage(mContext, item.getImageUrls()[0], (ImageView) helper.getView(R.id.iv_image1));
                }
                if (null != item.getImageUrls()[1]) {
                    GlideImageLoader.loadImage(mContext, item.getImageUrls()[1], (ImageView) helper.getView(R.id.iv_image2));
                }
                if (null != item.getImageUrls()[2]) {
                    GlideImageLoader.loadImage(mContext, item.getImageUrls()[2], (ImageView) helper.getView(R.id.iv_image3));
                }
                helper.setText(R.id.tv_timeStr, item.getTimeStr())
                        .setText(R.id.tv_title, item.getTitle())
                        .setText(R.id.tv_appName, item.getAppName())
                        .setText(R.id.tv_likeCount, "喜欢(" + item.getLikeCount() + ")");
                break;
            case NewsEntity.SIGNLE:
                if (null != item.getImageUrls()[0]) {
                    GlideImageLoader.loadImage(mContext, item.getImageUrls()[0], (ImageView) helper.getView(R.id.iv_image));
                }
                helper.setText(R.id.tv_title, item.getTitle())
                        .setText(R.id.tv_appName, item.getAppName())
                        .setText(R.id.tv_likeCount, "喜欢(" + item.getLikeCount() + ")");
                break;
        }
    }
}
