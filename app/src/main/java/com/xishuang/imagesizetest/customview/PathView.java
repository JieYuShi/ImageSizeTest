package com.xishuang.imagesizetest.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xishuang.imagesizetest.R;

/**
 * Created by xishuang on 2018/1/29.
 */
public class PathView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    private LinearGradient shader;
    private PorterDuffXfermode xfermode;

    public PathView(Context context) {
        super(context, null);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        ColorFilter filter = new LightingColorFilter(0xffffff, 0x003000);
        xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
//        PathEffect pathEffect = new CornerPathEffect(50);
        PathEffect pathEffect = new DashPathEffect(new float[]{20, 10, 5, 10}, 50);
        paint.setPathEffect(pathEffect);

//        new ComposeShader()
//        paint.setShader(shader);
//        paint.setColorFilter(filter);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        path.moveTo(100, 100);
        path.lineTo(300, 300);
        path.lineTo(200, 0);
        path.close();
        canvas.drawPath(path, paint);
    }
}
