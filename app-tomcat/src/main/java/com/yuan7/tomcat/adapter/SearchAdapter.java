package com.yuan7.tomcat.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.bean.impl.SearchEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class SearchAdapter extends BaseQuickAdapter<SearchEntity, BaseViewHolder> {

    public SearchAdapter(@Nullable List<SearchEntity> data) {
        super(R.layout.item_search, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchEntity item) {
        helper.setText(R.id.tv_title, item.getTitle());
    }
}
