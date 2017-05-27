package com.yuan7.tomcat.ui.main.recommend.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.bean.impl.RecommendBean;
import com.yuan7.tomcat.utils.GlideImageLoader;
import com.yuan7.tomcat.utils.Helper;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */

public class RecommendAdapter extends BaseQuickAdapter<RecommendBean.ResultBean, BaseViewHolder> {

    public RecommendAdapter(@Nullable List<RecommendBean.ResultBean> data) {
        super(R.layout.item_recommend, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendBean.ResultBean item) {
        if (item != null) {
            GlideImageLoader.loadImage(mContext, ServiceModule.BASE_URL + item.getImgUrl(), (ImageView) helper.getView(R.id.iv_pic));
            helper.setText(R.id.tv_title, item.getTitle())
                    .setText(R.id.tv_type, "游戏")
                    .setText(R.id.tv_content, item.getDesc())
                    .setText(R.id.tv_download_count, "已下载:" + item.getDownloadTimes())
                    .setText(R.id.tv_size, Helper.getPrintSize(item.getSize()));
            if (!TextUtils.isEmpty(item.getAddType())) {
                helper.setText(R.id.tv_game_type, item.getAddType());
            } else {
                helper.setText(R.id.tv_game_type, "角色扮演");
            }
            if (!TextUtils.isEmpty(item.getAppScore())) {
                helper.setText(R.id.tv_score, item.getAppScore() + "分");
            }

        }
    }
}
