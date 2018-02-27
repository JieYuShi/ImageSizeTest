package com.xishuang.imagesizetest.colorfilter;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.xishuang.imagesizetest.R;

public class ColorFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_colorfilter);
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        int memClass = activityManager.getMemoryClass();
        int memLargeClass = activityManager.getLargeMemoryClass();
        Toast.makeText(this, memClass + "M " + memLargeClass + "M", Toast.LENGTH_SHORT).show();
        ImageView imageView1 = (ImageView) findViewById(R.id.img1);
        if (imageView1 == null) return;
        Drawable drawable = imageView1.getDrawable();
        float[] targetMatrix = getSelfColorFilter();
        if (drawable != null) {
//            ColorFilter lightingColorFilter = new LightingColorFilter(0xffffff, 0x003000);
//            imageView1.getDrawable().setColorFilter(lightingColorFilter);
            drawable.setColorFilter(new ColorMatrixColorFilter(targetMatrix));
        }

    }

    private float[] getSelfColorFilter() {
        float[] targetMatrix = SpecialMatrix.getDiPian();
        return targetMatrix;
    }
}
