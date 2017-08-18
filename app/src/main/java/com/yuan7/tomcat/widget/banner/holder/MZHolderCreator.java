package com.yuan7.tomcat.widget.banner.holder;

/**
 * Created by Administrator on 2017/8/15.
 */


public interface MZHolderCreator<VH extends MZViewHolder> {
    /**
     * 创建ViewHolder
     * @return
     */
    public VH createViewHolder();
}
