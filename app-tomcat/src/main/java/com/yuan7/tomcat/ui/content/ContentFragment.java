package com.yuan7.tomcat.ui.content;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.video.lib.VideoPlayerStandard;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.helper.AHelper;
import com.yuan7.tomcat.interfaces.TitleBarListener;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.helper.KeyBoardListener;
import com.yuan7.tomcat.utils.LogUtil;
import com.yuan7.tomcat.utils.SPUtil;
import com.yuan7.tomcat.utils.SizeUtil;

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
        listener.setTitleText("内容");
        getIntentParams();
        LogUtil.i("id:" + id);
        LogUtil.i("image:" + image);
        LogUtil.i("content:" + content);
        LogUtil.i("title:" + title);

        if (type != 0) {
            video.setVisibility(View.GONE);
        } else {
            AHelper.showB(mActivity);
            if (content != null && title != null) {
                video.setUp(content, VideoPlayerStandard.SCREEN_LAYOUT_LIST, title);
            }
            if (image != null) {
                GlideImageLoader.loadImage(image, video.thumbImageView);
            }
        }

        video.setPayListener(new VideoPlayerStandard.PlayerListener() {
            @Override
            public void onNormal() {

            }

            @Override
            public void onPause() {
                AHelper.showS(mActivity);
            }

            @Override
            public void onPlayer() {

            }

            @Override
            public void onPlay() {

            }
        });

        KeyBoardListener.getInstance(mActivity).init();

        if (Build.BRAND.equals("HONOR")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(0, 0, 0, SizeUtil.dp2px(mActivity, 36));
            web.setLayoutParams(layoutParams);
        }
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

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Map<String, String> map = new HashMap<>();
                map.put("yuan7-token", (String) SPUtil.get(UserParams.USER_TOKEN, ""));
                LogUtil.i("URL:" + url);
                view.loadUrl(url, map);
                return true;
            }
        });
        web.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && web.canGoBack()) {  //表示按返回键
                        web.goBack();   //后退
                        //web.goForward();//前进
                        return true;
                    }
                }
                return false;
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
