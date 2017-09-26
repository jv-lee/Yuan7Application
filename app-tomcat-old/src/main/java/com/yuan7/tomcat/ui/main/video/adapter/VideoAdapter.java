package com.yuan7.tomcat.ui.main.video.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.bean.ResultBean;
import com.yuan7.tomcat.bean.impl.VideoBean;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */

public class VideoAdapter extends BaseQuickAdapter<ResultBean, BaseViewHolder> {

    public VideoAdapter(@Nullable List<ResultBean> data) {
        super(R.layout.item_video, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ResultBean item) {
        if (item != null) {
            GlideImageLoader.loadImage(mContext, ServiceModule.BASE_URL + item.getImgUrl(), (ImageView) helper.getView(R.id.iv_pic));
            helper.setText(R.id.tv_title, item.getTitle())
                    .setText(R.id.tv_time, item.getAddTime())
                    .setText(R.id.tv_read, mContext.getResources().getString(R.string.str_play) + "\t" + item.getClickTimes());
        }
    }
}
