package com.yuan7.tomcat.ui.content;

import android.widget.FrameLayout;
import android.widget.TextView;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.interfaces.TitleBarListener;

import butterknife.BindView;

public class ContentActivity extends BaseActivity implements TitleBarListener {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected int bindRootView() {
        return R.layout.activity_content;
    }

    @Override
    protected void bindData() {
        mFragmentManager.beginTransaction().replace(R.id.fl_container,new ContentFragment(this)).commit();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
    }

    @Override
    public void setTitleText(String text) {
        tvTitle.setText(text);
    }
}
