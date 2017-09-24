package com.yuan7.tomcat.ui.content;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.video.lib.VideoPlayerStandard;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.interfaces.TitleBarListener;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.helper.KeyBoardListener;
import com.yuan7.tomcat.utils.LogUtil;
import com.yuan7.tomcat.utils.SPUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends BaseFragment {

    @BindView(R.id.web)
    WebView web;
    @BindView(R.id.video_container)
    VideoPlayerStandard video;

    private String title, image, content;
    private int type, id;

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
        getIntentParams();
        LogUtil.i("id:" + id);
        LogUtil.i("image:" + image);
        LogUtil.i("content:" + content);
        LogUtil.i("title:" + title);

        if (type != 0) {
            video.setVisibility(View.GONE);
        } else {
            if (content != null && title != null) {
                video.setUp(content, VideoPlayerStandard.SCREEN_LAYOUT_LIST, title);
            }
            if (image != null) {
                GlideImageLoader.loadImage(image, video.thumbImageView);
            }
        }

        KeyBoardListener.getInstance(mActivity).init();
        listener.setTitleText("内容");

        web.getSettings().setJavaScriptEnabled(true);
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
        Map<String, String> map = new HashMap<>();
        map.put("yuan7-token", (String) SPUtil.get(UserParams.USER_TOKEN, ""));
        web.loadUrl(Constant.CONTENT_URL + id, map);

    }

    private void getIntentParams() {
        title = mActivity.getIntent().getStringExtra(Constant.FRAGMENT_TITLE);
        image = mActivity.getIntent().getStringExtra(Constant.FRAGMENT_IMAGE);
        content = mActivity.getIntent().getStringExtra(Constant.FRAGMENT_CONTENT);
        type = mActivity.getIntent().getIntExtra(Constant.FRAGMENT_TYPE, 0);
        id = mActivity.getIntent().getIntExtra(Constant.FRAGMENT_ID, 0);
    }

    @Override
    protected void lazyLoad() {
    }

}
