package com.yuan7.tomcat.ui.content.video;

import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lcodecore.tkrefreshlayout.utils.LogUtil;
import com.video.lib.VideoPlayer;
import com.video.lib.VideoPlayerStandard;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.utils.GlideImageLoader;

import butterknife.BindView;
import qse.drg.znhx.nqi;

public class VideoDataActivity extends BaseActivity {

    @BindView(R.id.videoView)
    VideoPlayerStandard videoView;
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
        return R.layout.activity_video_data;
    }

    @Override
    protected void bindData() {
//        mSwipeBackLayout.setEnableGesture(false);

        tvTitle.setText(getResources().getString(R.string.str_video));
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

//        String url = "http://data.vod.itc.cn/?rb=1&prot=1&key=jbZhEJhlqlUN-Wj_HEI8BjaVqKNFvDrn&prod=flash&pt=1&new=/86/173/5GipN9Q9kTylfL9xPZg7kN.mp4";
        String url = getIntent().getStringExtra("apiUrl");
        Log.i(TAG, "url:"+url);
        videoView.setUp(url
                , VideoPlayerStandard.SCREEN_LAYOUT_NORMAL, getIntent().getStringExtra("title"));
//        videoView.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        GlideImageLoader.loadImage(this, getIntent().getStringExtra("imageUrl"), videoView.thumbImageView);
        videoView.setPayListener(new VideoPlayerStandard.PlayerListener() {
            @Override
            public void onNormal() {

            }

            @Override
            public void onPause() {
                nqi.showC();
            }

            @Override
            public void onPlayer() {

            }

            @Override
            public void onPlay() {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (VideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        VideoPlayer.releaseAllVideos();
    }

    protected void setupActivityComponent(AppComponent appComponent) {

    }
}
