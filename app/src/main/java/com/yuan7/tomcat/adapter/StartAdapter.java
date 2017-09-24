package com.yuan7.tomcat.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.helper.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */

public class StartAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public StartAdapter(@Nullable List<String> data) {
        super(R.layout.item_startbanner, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        GlideImageLoader.loadImage(item, (ImageView) helper.getView(R.id.iv_icon));
        ((ImageView) helper.getView(R.id.iv_icon)).setImageDrawable(mContext.getDrawable(R.mipmap.welcome));
    }
}
