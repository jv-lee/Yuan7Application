package com.yuan7.tomcat.widget.back;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yuan7.tomcat.R;


/**
 * Created by Administrator on 2017/6/29.
 */

public class IosBackActivity extends AppCompatActivity {
    protected IosBackHelper mHelper;

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mHelper = new IosBackHelper(this);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    @NonNull
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHelper.onActivityDestroy();
    }

    protected IosBackLayout getBackLayout() {
        return mHelper.getBackLayout();
    }

    protected void setBackEnable(boolean enable) {
        mHelper.setBackEnable(enable);
    }

    protected void scrollToFinishActivity() {
        mHelper.scrollToFinishActivity();
    }

    @Override
    public void onBackPressed() {
        if (!getSupportFragmentManager().popBackStackImmediate()) {
            scrollToFinishActivity();
        }
    }

    // 覆盖以下方法,设置动画.
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_right_in,
                R.anim.slide_left_out);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.slide_right_in,
                R.anim.zoom_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_left_in,
                R.anim.slide_right_out);
    }

}
