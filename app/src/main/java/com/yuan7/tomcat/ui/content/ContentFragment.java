package com.yuan7.tomcat.ui.content;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.interfaces.TitleBarListener;
import com.yuan7.tomcat.utils.KeyBoardListener;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends BaseFragment {

    @BindView(R.id.web)
    WebView web;

    private TitleBarListener listener;

    public ContentFragment(TitleBarListener listener) {
        this.listener = listener;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    protected void bindData() {
        KeyBoardListener.getInstance(mActivity).init();
        listener.setTitleText("内容");
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    view.loadUrl("javascript:token('Toast');");
                }
            }
        });
        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        web.loadUrl("http://192.168.3.80:8080/comment.html");

    }

    @Override
    protected void lazyLoad() {

    }

}
