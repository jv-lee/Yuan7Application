package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.impl.MessageEntity;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.utils.TimeUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */

public class MessageAdapter extends BaseQuickAdapter<MessageEntity, BaseViewHolder> {

    public MessageAdapter(@Nullable List<MessageEntity> data) {
        super(R.layout.item_message, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageEntity item) {
        GlideImageLoader.loadImage(item.getInteractUser().getImage(), (ImageView) helper.getView(R.id.riv_userIcon));
        helper.setText(R.id.tv_userName, item.getInteractUser().getName())
//                .setText(R.id.tv_messageContent, item.getMessage())
                .setText(R.id.tv_dateStr, TimeUtil.getChineseTimeMill(item.getMsgTime()));
    }
}
