package com.xishuang.imagesizetest.colorfilter;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

        final ImageView imageView2 = (ImageView) findViewById(R.id.img2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ImageUtil.displayImage(imageView2, R.drawable.bg5);
                ImageUtil.displayImageSobel(getApplicationContext(), imageView2, R.drawable.bg5);
            }
        });

    }
}
