package com.xishuang.imagesizetest.colorfilter;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by xishuang on 2018/2/5.
 */

public class SpecialImageView extends AppCompatImageView {
    public SpecialImageView(Context context) {
        this(context, null);
    }

    public SpecialImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        getDrawable();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
