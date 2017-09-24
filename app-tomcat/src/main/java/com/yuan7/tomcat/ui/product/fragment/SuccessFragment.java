package com.yuan7.tomcat.ui.product.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.interfaces.ProductSelectInterface;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuccessFragment extends BaseFragment {

    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private ProductSelectInterface productSelectInterface;

    public SuccessFragment(ProductSelectInterface productSelectInterface) {
        this.productSelectInterface = productSelectInterface;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_success, container, false);
    }

    @Override
    protected void bindData() {
        tvTitle.setText("兑换成功");
        ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }

    @Override
    protected void lazyLoad() {

    }

}
