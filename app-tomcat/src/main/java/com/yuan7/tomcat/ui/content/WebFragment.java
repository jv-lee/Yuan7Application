package com.yuan7.tomcat.ui.content;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.interfaces.TitleBarListener;
import com.yuan7.tomcat.utils.SPUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class WebFragment extends BaseFragment {

    @BindView(R.id.web)
    WebView web;

    private TitleBarListener listener;

    public WebFragment(TitleBarListener listener) {
        this.listener = listener;
    }


    @Override
    protected void componentInject(AppComponent appComponent) {
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web, container, false);
    }

    @Override
    protected void bindData() {

        listener.setTitleText("WEB");

        String url = mActivity.getIntent().getStringExtra(Constant.FRAGMENT_CONTENT);

        web.getSettings().setJavaScriptEnabled(true);
        web.setBackgroundColor(getResources().getColor(R.color.colorFragmentBackground));
        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
//                    view.loadUrl("javascript:token('Toast');");
                }
            }
        });
        web.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        web.loadUrl(url);

    }

    @Override
    protected void lazyLoad() {

    }

}
