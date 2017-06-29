package com.yuan7.tomcat.widget.back;

import android.app.Activity;
import android.graphics.Canvas;
import android.view.View;

import java.util.Stack;

/**
 * Created by sunshuntao.
 */
public class IosBackHelper {
    private static final Stack<IosBackHelper> sActivities = new Stack<>();

    public Activity getActivity() {
        return mActivity;
    }

    private Activity mActivity;

    private IosBackLayout mIosBackLayout;

    public IosBackHelper(Activity activity) {
        mActivity = activity;
        mIosBackLayout = new IosBackLayout(mActivity);
        sActivities.push(this);
    }

    public boolean hasSecondActivity() {
        return sActivities.size() >= 2;
    }

    public void onPostCreate() {
        mIosBackLayout.attachToActivity(this);
    }

    public void onActivityDestroy() {
        sActivities.remove(this);
    }

    public IosBackHelper getSecondActivity() {
        if (sActivities.size() >= 2)
            return sActivities.elementAt(sActivities.size() - 2);
        return null;
    }

    public void drawThumb(Canvas canvas) {
        View decorChild = getBackLayout().getContentView();
        decorChild.draw(canvas);
    }

    public View findViewById(int id) {
        if (mIosBackLayout != null) {
            return mIosBackLayout.findViewById(id);
        }
        return null;
    }

    public void scrollToFinishActivity() {
        getBackLayout().scrollToFinishActivity();
    }

    public void setBackEnable(boolean enable) {
        getBackLayout().setEnableGesture(enable);
    }

    public IosBackLayout getBackLayout() {
        return mIosBackLayout;
    }
}
