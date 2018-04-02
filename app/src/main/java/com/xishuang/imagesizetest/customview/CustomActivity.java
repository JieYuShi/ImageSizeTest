package com.xishuang.imagesizetest.customview;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xishuang.imagesizetest.R;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_custom);
        CustomView imageView = (CustomView) findViewById(R.id.img3);
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();

        Log.d("CustomActivity", drawable.toString());
    }
}
