package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.impl.ReplyEntity;
import com.yuan7.tomcat.utils.TimeUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class ReplyAdapter extends BaseQuickAdapter<ReplyEntity, BaseViewHolder> {

    public ReplyAdapter(@Nullable List<ReplyEntity> data) {
        super(R.layout.item_post_reply, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReplyEntity item) {
        helper.setText(R.id.tv_reply_title, item.getNewsTitle())
                .setText(R.id.tv_reply_user_name, "")
                .setText(R.id.tv_reply_date, TimeUtil.milliseconds2String(item.getCommentDate()))
                .setText(R.id.tv_reply_message, item.getCommentContent())
                .setText(R.id.tv_timeStr, TimeUtil.getChineseTimeMill(item.getCommentDate()))
                .setText(R.id.tv_readCount, String.valueOf(item.getCommentViewNum()))
                .setText(R.id.tv_inputCount, String.valueOf(item.getCommentCommentNum()))
                .setText(R.id.tv_niceCount, String.valueOf(item.getCommentGoodNum()));
    }
}
