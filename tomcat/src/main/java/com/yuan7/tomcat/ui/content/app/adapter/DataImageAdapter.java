package com.yuan7.tomcat.ui.content.app.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */

public class DataImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public DataImageAdapter(@Nullable List<String> data) {
        super(R.layout.item_app_imgs, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        GlideImageLoader.loadImage(mContext, ServiceModule.BASE_URL + item, (ImageView) helper.getView(R.id.iv_app_icon));
    }
}
