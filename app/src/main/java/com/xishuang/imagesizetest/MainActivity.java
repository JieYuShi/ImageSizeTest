package com.xishuang.imagesizetest;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TouchActivity";
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3:4:6:8:12:16 缩放比率
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        Log.d(TAG, " scale = " + scale);
        img = (ImageView) findViewById(R.id.img);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        printBitmapSize(img);
    }

    private void printBitmapSize(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int size;
            Log.d(TAG, " width = " + width + " height = " + height);
            Log.d(TAG, " total_pixel = width * height = " + width * height);
            //API 19
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                size = bitmap.getAllocationByteCount();
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1){
                //API 12
                size = bitmap.getByteCount();
            } else {
                //earlier version
                size = bitmap.getRowBytes() * bitmap.getHeight();
            }
            Log.d(TAG, " size = " + size);
            Log.d(TAG, " scale = size / total_pixel = " + size / (width * height));
        } else {
            Log.d(TAG, "Drawable is null !");
        }
    }
}
