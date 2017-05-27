package com.yuan7.tomcat.ui.content.app.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.bean.impl.HotAdBean;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */

public class DataHotAdapter extends BaseQuickAdapter<HotAdBean.ResultBean, BaseViewHolder> {

    public DataHotAdapter(@Nullable List<HotAdBean.ResultBean> data) {
        super(R.layout.item_app_apps, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HotAdBean.ResultBean item) {
        GlideImageLoader.loadImage(mContext, ServiceModule.BASE_URL + item.getImgUrl(), (ImageView) helper.getView(R.id.iv_app_icon));
        helper.setText(R.id.iv_app_name, item.getTitle());
    }
}
