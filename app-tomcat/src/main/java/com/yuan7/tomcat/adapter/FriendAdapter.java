package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.bean.impl.FriendEntity;
import com.yuan7.tomcat.helper.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */

public class FriendAdapter extends BaseQuickAdapter<FriendEntity, BaseViewHolder> {

    public FriendAdapter(@Nullable List<FriendEntity> data) {
        super(R.layout.item_friend, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FriendEntity item) {
        GlideImageLoader.loadCircleCropBg(item.getImage(), (ImageView) helper.getView(R.id.iv_icon));
        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_sendCount, "发帖\t" + item.getNewsNum())
                .setText(R.id.tv_replyCount, "被赞\t" + item.getGoodNum())
                .setText(R.id.tv_friendCount, "好友\t" + item.getFriendCount())
                .setText(R.id.tv_levelNum,"LV"+item.getLevel());

        switch (helper.getLayoutPosition()) {
            case 0:
                helper.setBackgroundRes(R.id.tv_rankLevel, R.mipmap.item_icon_one);
                break;
            case 1:
                helper.setBackgroundRes(R.id.tv_rankLevel, R.mipmap.item_icon_tow);
                break;
            case 2:
                helper.setBackgroundRes(R.id.tv_rankLevel, R.mipmap.item_icon_third);
                break;
            default:
                helper.setBackgroundRes(R.id.tv_rankLevel, R.mipmap.item_icon_level);
                helper.setText(R.id.tv_rankLevel, String.valueOf(helper.getLayoutPosition() + 1));
                break;
        }
    }

}
