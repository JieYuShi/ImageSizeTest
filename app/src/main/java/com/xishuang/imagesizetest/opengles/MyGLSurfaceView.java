package com.xishuang.imagesizetest.opengles;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

/**
 * Author:xishuang
 * Date:2018/1/2.
 */
public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mGLRenderer;

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;

    public MyGLSurfaceView(Context context) {
        super(context);
        // 创建一个OpenGL ES 2.0的context
        setEGLContextClientVersion(2);

        // 设置在GLSurfaceView绘制用的渲染器
        mGLRenderer = new MyGLRenderer();
        setRenderer(mGLRenderer);

        // 设置绘制数据变化的时候才会重新渲染
//        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:

                float dx = x - mPreviousX;
                float dy = y - mPreviousY;
                if (y > getHeight() / 2) {
                    dx = dx * -1;
                }
                if (x < getWidth() / 2) {
                    dy = dy * -1;
                }
                mGLRenderer.setAngle(mGLRenderer.getAngle() + (dx + dy) * TOUCH_SCALE_FACTOR);
                requestRender();
        }

        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}
