package com.yuan7.tomcat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/10/9.
 */

@SuppressLint("AppCompatCustomView")
public class FontTextView extends TextView {
    private final static String FONT = "fonts/custom_font.ttf";

    public FontTextView(Context context) {
        super(context);
    }

    public FontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void replaceCustomFont() {
        Typeface typeface = getTypeface();
        int style = Typeface.NORMAL;
        if (typeface != null) {
            style = typeface.getStyle();
        }
        Typeface newTypeface = Typeface.createFromAsset(getContext().getAssets(), FONT);
        setTypeface(newTypeface);
    }

}
