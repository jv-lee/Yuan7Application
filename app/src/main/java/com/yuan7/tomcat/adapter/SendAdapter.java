package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.SendEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class SendAdapter extends BaseQuickAdapter<SendEntity,BaseViewHolder>{

    public SendAdapter( @Nullable List<SendEntity> data) {
        super(R.layout.item_post_send, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SendEntity item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_content, item.getContent())
                .setText(R.id.tv_day, item.getDay())
                .setText(R.id.tv_month, item.getMonth())
                .setText(R.id.tv_readCount, String.valueOf(item.getReadCount()))
                .setText(R.id.tv_inputCount, String.valueOf(item.getInputCount()))
                .setText(R.id.tv_niceCount, String.valueOf(item.getNiceCount()));
    }
}
