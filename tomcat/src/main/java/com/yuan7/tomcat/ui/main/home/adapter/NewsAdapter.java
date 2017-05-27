package com.yuan7.tomcat.ui.main.home.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.Config;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.bean.impl.NewsBean;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/5/18.
 */

public class NewsAdapter extends BaseQuickAdapter<NewsBean.ResultBean, BaseViewHolder> {

    public NewsAdapter(@Nullable List<NewsBean.ResultBean> data) {
        super(R.layout.item_home, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsBean.ResultBean item) {
        GlideImageLoader.loadImage(mContext,ServiceModule.BASE_URL + item.getImgUrl(),(ImageView) helper.getView(R.id.iv_pic));
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_content, item.getDesc())
                .setText(R.id.tv_time, item.getAddTime());
        switch (item.getType()) {
            case Config.TYPE_NEWS:
                helper.setText(R.id.tv_type, mContext.getResources().getString(R.string.str_news));
                helper.setBackgroundRes(R.id.tv_type, R.drawable.bg_news_type);
                helper.setTextColor(R.id.tv_type, mContext.getResources().getColor(R.color.typeColor_news));
                helper.setText(R.id.tv_type_count, mContext.getResources().getString(R.string.str_read) + "\t" + item.getClickTimes());
                break;
            case Config.TYPE_VIDEO:
                helper.setText(R.id.tv_type, mContext.getResources().getString(R.string.str_video));
                helper.setBackgroundRes(R.id.tv_type, R.drawable.bg_video_type);
                helper.setTextColor(R.id.tv_type, mContext.getResources().getColor(R.color.typeColor_video));
                helper.setText(R.id.tv_type_count, mContext.getResources().getString(R.string.str_read) + "\t" + item.getClickTimes());
                break;
            case Config.TYPE_APP:
                helper.setText(R.id.tv_type, mContext.getResources().getString(R.string.str_app));
                helper.setBackgroundRes(R.id.tv_type, R.drawable.bg_app_type);
                helper.setTextColor(R.id.tv_type, mContext.getResources().getColor(R.color.typeColor_app));
                helper.setText(R.id.tv_type_count, mContext.getResources().getString(R.string.str_download) + "\t" + item.getDownloadTimes());
                break;
        }

    }
}
