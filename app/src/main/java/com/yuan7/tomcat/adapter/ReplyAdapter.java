package com.yuan7.tomcat.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.ReplyEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class ReplyAdapter extends BaseQuickAdapter<ReplyEntity,BaseViewHolder>{

    public ReplyAdapter(@Nullable List<ReplyEntity> data) {
        super(R.layout.item_post_reply, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReplyEntity item) {
        helper.setText(R.id.tv_reply_title, item.getTitle())
                .setText(R.id.tv_reply_message, item.getContent())
                .setText(R.id.tv_reply_date, item.getDateStr())
                .setText(R.id.tv_readCount, String.valueOf(item.getReadCount()))
                .setText(R.id.tv_inputCount, String.valueOf(item.getInputCount()))
                .setText(R.id.tv_niceCount, String.valueOf(item.getNiceCount()));
    }
}
