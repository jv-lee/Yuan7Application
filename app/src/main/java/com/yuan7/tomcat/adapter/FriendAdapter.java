package com.yuan7.tomcat.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.FriendEntity;
import com.yuan7.tomcat.utils.GlideImageLoader;

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
        GlideImageLoader.loadImage(mContext, item.getIconUrl(), (ImageView) helper.getView(R.id.iv_icon));
        helper.setText(R.id.tv_rankLevel, String.valueOf(item.getRankLevel()))
                .setText(R.id.tv_name, item.getName());
        ((RatingBar) helper.getView(R.id.rating_userLevel)).setRating(item.getUserLevel());
    }
}
