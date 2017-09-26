package com.yuan7.tomcat.ui.content;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.video.lib.VideoPlayer;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.interfaces.TitleBarListener;
import com.yuan7.tomcat.utils.ShareUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class ContentActivity extends BaseActivity implements TitleBarListener, View.OnLayoutChangeListener {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.iv_right)
    ImageView ivRight;

    private String title = "";
    private String url = "";

    //Activity最外层的Layout视图
    private View activityRootView;
    //屏幕高度
    private int screenHeight = 0;
    //软件盘弹起后所占高度阀值
    private int keyHeight = 0;

    @Override
    protected int bindRootView() {
        return R.layout.activity_content;
    }

    @Override
    protected void bindData() {
        ivRight.setImageResource(R.drawable.selector_appbar_share);
        ivRight.setVisibility(View.VISIBLE);

        activityRootView = findViewById(R.id.root_view);
        //获取屏幕高度
        screenHeight = this.getWindowManager().getDefaultDisplay().getHeight();
        //阀值设置为屏幕高度的1/3
        keyHeight = screenHeight / 3;
        hideBar();

        boolean hasAd = getIntent().getBooleanExtra("ad", false);

        if (hasAd) {
            mFragmentManager.beginTransaction().replace(R.id.fl_container, new WebFragment(this)).commit();
        } else {
            mFragmentManager.beginTransaction().replace(R.id.fl_container, new ContentFragment(this)).commit();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        //添加layout大小发生改变监听器
        activityRootView.addOnLayoutChangeListener(this);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
    }

    @Override
    public void setTitleText(String text) {
        tvTitle.setText(text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        VideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (VideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @OnClick({R.id.iv_left, R.id.iv_right})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.iv_right:
                ShareUtil.shareText(this, "汤姆猫资讯：" + getIntent().getStringExtra(Constant.FRAGMENT_TITLE) + "\t URL:" + Constant.CONTENT_URL + getIntent().getIntExtra(Constant.FRAGMENT_ID, 0));
                break;
        }
    }

    @Override
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

        //old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值

//      System.out.println(oldLeft + " " + oldTop +" " + oldRight + " " + oldBottom);
//      System.out.println(left + " " + top +" " + right + " " + bottom);


        //现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起
        if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {


        } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {


        }
    }

    public void hideBar(){
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
//            View v = this.getWindow().getDecorView();
//            v.setSystemUiVisibility(View.GONE);
//        } else if (Build.VERSION.SDK_INT >= 19) {
//            //for new api versions.
//            View decorView = getWindow().getDecorView();
//            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//        }
    }
}
