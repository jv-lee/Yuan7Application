package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.impl.PostEntity;
import com.yuan7.tomcat.utils.TimeUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class PostAdapter extends BaseQuickAdapter<PostEntity, BaseViewHolder> {

    public PostAdapter(@Nullable List<PostEntity> data) {
        super(R.layout.item_post_send, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PostEntity item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_dateStr, item.getCreatTime())
                .setText(R.id.tv_timeStr, TimeUtil.getChineseTimeMill(TimeUtil.string2Milliseconds(item.getCreatTime())))
                .setText(R.id.tv_readCount, String.valueOf(item.getViewTimes()))
                .setText(R.id.tv_inputCount, String.valueOf(item.getCommentRate()))
                .setText(R.id.tv_niceCount, String.valueOf(item.getGootRate()));
    }
}
