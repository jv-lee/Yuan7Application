package com.yuan7.tomcat.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.bean.impl.ContentEntity;

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
//                if (item.getSize() > 0) {
//                    GlideImageLoader.loadImage(mContext, item.getImages().get(0).getUrl(), (ImageView) helper.getView(R.id.iv_image1));
//                }
//                if (item.getSize() > 1) {
//                    GlideImageLoader.loadImage(mContext, item.getImages().get(1).getUrl(), (ImageView) helper.getView(R.id.iv_image2));
//                }
//                if (item.getSize() > 2) {
//                    GlideImageLoader.loadImage(mContext, item.getImages().get(2).getUrl(), (ImageView) helper.getView(R.id.iv_image3));
//                }
                helper.setText(R.id.tv_timeStr, item.getEditeTime())
                        .setText(R.id.tv_title, item.getTitle())
                        .setText(R.id.tv_appName, item.getSource())
                        .setText(R.id.tv_likeCount, "喜欢(" + item.getGootRate() + ")");
                break;
            case ContentEntity.SIGNLE:
//                if (item.getSize() > 0) {
//                    GlideImageLoader.loadImage(mContext, item.getImages().get(0).getUrl(), (ImageView) helper.getView(R.id.iv_image1));
//                }
                helper.setText(R.id.tv_title, item.getTitle())
                        .setText(R.id.tv_appName, item.getSource())
                        .setText(R.id.tv_likeCount, "喜欢(" + item.getGootRate() + ")");
                break;
        }
    }
}
