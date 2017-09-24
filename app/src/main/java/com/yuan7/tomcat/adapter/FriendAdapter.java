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
        GlideImageLoader.loadImage(item.getImage(), (ImageView) helper.getView(R.id.iv_icon));
        helper.setText(R.id.tv_name, item.getName());
        ((RatingBar) helper.getView(R.id.rating_userLevel)).setRating(item.getLevel());

//        .setText(R.id.tv_rankLevel, String.valueOf(helper.getLayoutPosition() + 1))
        switch (helper.getLayoutPosition()) {
            case 0:
                helper.setText(R.id.tv_rankLevel, "排名第一");
                break;
            case 1:
                helper.setText(R.id.tv_rankLevel, "排名第二");
                break;
            case 2:
                helper.setText(R.id.tv_rankLevel, "排名第三");
                break;
            default:
                helper.setText(R.id.tv_rankLevel, String.valueOf(helper.getLayoutPosition() + 1));
                break;
        }
    }

}
