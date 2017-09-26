package com.yuan7.tomcat.ui.content;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.utils.SPUtil;
import com.yuan7.tomcat.utils.StatusBarUtil;

import java.util.HashMap;
import java.util.Map;

public class ActiveActivity extends Activity {

    private WebView web;
    private ImageView ivClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active);

        ivClose = (ImageView) findViewById(R.id.iv_close);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
            }
        });
        web = (WebView) findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    hasBackExit = false;
                }
            }
        });
        web.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Map<String, String> map = new HashMap<>();
                map.put("yuan7-token", (String) SPUtil.get(UserParams.USER_TOKEN, ""));
                view.loadUrl(Constant.ACTIVI_URL, map);
                return true;
            }
        });
        Map<String, String> map = new HashMap<>();
        map.put("yuan7-token", (String) SPUtil.get(UserParams.USER_TOKEN, ""));
        web.loadUrl(Constant.ACTIVI_URL, map);
    }

    private boolean hasBackExit = true;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (hasBackExit) {
                    Toast.makeText(this, "稍等片刻，正在加载活动页面~", Toast.LENGTH_SHORT).show();
                    return true;
                }
        }
        return super.onKeyUp(keyCode, event);
    }


    @Override
    protected void onResume() {
        super.onResume();
//        StatusBarUtil.backgroundAlpha(this, 0.5f);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        StatusBarUtil.backgroundAlpha(this, 1.0f);
    }
}
