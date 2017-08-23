package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.AQEntity;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */

public class AQAdapter extends BaseQuickAdapter<AQEntity, BaseViewHolder> {

    public AQAdapter(@Nullable List<AQEntity> data) {
        super(R.layout.item_aq, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AQEntity item) {
        GlideImageLoader.loadImage(mContext, item.getIconUrl(), (ImageView) helper.getView(R.id.iv_icon));
        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_timeStr, item.getDateStr())
                .setText(R.id.tv_deviceSource, "来自" + item.getDeviceSource())
                .setText(R.id.tv_contentMessage, item.getContentMessage())
                .setText(R.id.tv_readCount, "浏览量:" + item.getReadCount())
                .setText(R.id.tv_inputCount, String.valueOf(item.getInputCount()))
                .setText(R.id.tv_niceCount, String.valueOf(item.getNiceCount()))
                .setText(R.id.tv_goldCount, "悬赏  " + item.getGoldCount());
    }
}
