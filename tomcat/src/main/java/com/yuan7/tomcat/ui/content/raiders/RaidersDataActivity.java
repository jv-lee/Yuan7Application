package com.yuan7.tomcat.ui.content.raiders;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;

import butterknife.BindView;
import qse.drg.znhx.nqi;

public class RaidersDataActivity extends BaseActivity {

    @BindView(R.id.wv_container)
    WebView wvContainer;
    @BindView(R.id.toolbar)
    LinearLayout toolbar;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected int bindRootView() {
        return R.layout.activity_raiders_data;
    }

    @Override
    protected void bindData() {
        tvTitle.setText(getResources().getString(R.string.str_text));
        ivLeft.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
        ivLeft.setVisibility(View.VISIBLE);
        ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nqi.Showb();
                finish();
            }
        });
        wvContainer.getSettings().setJavaScriptEnabled(true);
        wvContainer.setWebChromeClient(new WebChromeClient());
        wvContainer.setWebViewClient(new WebViewClient());
        wvContainer.loadUrl(getIntent().getStringExtra("contentUrl"));
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }
}
