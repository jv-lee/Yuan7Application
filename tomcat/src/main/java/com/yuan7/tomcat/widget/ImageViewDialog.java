package com.yuan7.tomcat.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李鹏 on 2017/03/30 0030.
 */

public class ImageViewDialog {

    private Context context;
    private Dialog dialog;
    private ViewPager viewPager;
    private List<String> imgList;
    private ViewpagerAdpter viewpagerAdpter;
    private List<View> viewList;
    private TextView tvNum;
    private int position;

    public ImageViewDialog(Context context, List<String> imgList, int position) {
        this.context = context;
        this.imgList = imgList;
        this.position = position;
        initDialog();
    }

    private void initDialog() {
        if (dialog == null) {
            dialog = new Dialog(context, android.R.style.Animation_Dialog);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_view, null);
            viewPager = (ViewPager) view.findViewById(R.id.viewpager);
            tvNum = (TextView) view.findViewById(R.id.num);
            tvNum.setText(position + 1 + "/" + imgList.size());
            dialog.setContentView(view);
        }
        viewList = new ArrayList<>();
        for (int i = 0; i < imgList.size(); i++) {
            View imgView = LayoutInflater.from(context).inflate(R.layout.item_img, null);
            PhotoView photoView = (PhotoView) imgView.findViewById(R.id.photo_view);
            GlideImageLoader.loadImage(context, ServiceModule.BASE_URL + imgList.get(i), photoView);
            viewList.add(imgView);
        }
        viewpagerAdpter = new ViewpagerAdpter(viewList);
        viewPager.setAdapter(viewpagerAdpter);
        viewPager.setCurrentItem(position);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvNum.setText((position + 1) + "/" + imgList.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void show() {
        if (dialog != null) {
            dialog.show();
        }
    }

    public void hide() {
        if (dialog != null) {
            dialog.hide();
        }
    }


    public Dialog getDialog() {
        return dialog;
    }
}
