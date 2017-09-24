package com.yuan7.tomcat.helper;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

import com.yuan7.tomcat.utils.SizeUtil;

/**
 * Created by Administrator on 2017/8/30.
 */

public class KeyBoardListener {
    private static Activity mActivity;
// private Handler mhanHandler;


    private View mChildOfContent;
    private int usableHeightPrevious;
    private FrameLayout.LayoutParams frameLayoutParams;

    private static KeyBoardListener keyBoardListener;


    public static KeyBoardListener getInstance(Activity activity) {
        mActivity = activity;
// if(keyBoardListener==null){
        keyBoardListener = new KeyBoardListener(activity);
// }
        return keyBoardListener;
    }


    public KeyBoardListener(Activity activity) {
        super();
// TODO Auto-generated constructor stub
        this.mActivity = activity;
// this.mhanHandler = handler;

    }


    public void init() {
        FrameLayout content = (FrameLayout) mActivity
                .findViewById(android.R.id.content);
        mChildOfContent = content.getChildAt(0);
        mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        possiblyResizeChildOfContent();
                    }
                });
        frameLayoutParams = (FrameLayout.LayoutParams) mChildOfContent
                .getLayoutParams();
    }


    private void possiblyResizeChildOfContent() {
        int usableHeightNow = computeUsableHeight();
        if (usableHeightNow != usableHeightPrevious) {
            int usableHeightSansKeyboard = mChildOfContent.getRootView().getHeight();
            int heightDifference = usableHeightSansKeyboard - usableHeightNow;
            if (heightDifference > (usableHeightSansKeyboard / 4)) {
                // keyboard probably just became visible
                frameLayoutParams.height = usableHeightSansKeyboard
                        - heightDifference;
            } else {
                // keyboard probably just became hidden
                frameLayoutParams.height = usableHeightSansKeyboard;
            }
            mChildOfContent.requestLayout();
            usableHeightPrevious = usableHeightNow;
        }
    }


    private int computeUsableHeight() {
        Rect r = new Rect();
        mChildOfContent.getWindowVisibleDisplayFrame(r);
        if (Build.BRAND.equals("HONOR")) {
            return (r.bottom - r.top) + SizeUtil.dp2px(mActivity, 60);
        }else{
            return (r.bottom - r.top) + SizeUtil.dp2px(mActivity, 20);
        }


    }

}
