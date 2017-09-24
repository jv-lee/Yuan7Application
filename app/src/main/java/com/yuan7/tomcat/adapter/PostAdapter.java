package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.bean.impl.PostEntity;

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
                .setText(R.id.tv_content, item.getBriefIntroduction())
                .setText(R.id.tv_day, item.getCreatTime().substring(8, 10))
                .setText(R.id.tv_month, item.getCreatTime().substring(5, 7) + "月")
                .setText(R.id.tv_readCount, String.valueOf(item.getViewTimes()))
                .setText(R.id.tv_inputCount, String.valueOf(item.getCommentRate()))
                .setText(R.id.tv_niceCount, String.valueOf(item.getGootRate()));
    }
}
