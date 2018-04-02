package com.xishuang.imagesizetest.colorfilter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.xishuang.imagesizetest.R;

public class ColorFilterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_colorfilter);

        findViewById(R.id.bt_lighting).setOnClickListener(this);
        findViewById(R.id.bt_porterduff).setOnClickListener(this);
        findViewById(R.id.bt_colormatrix).setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.img);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_lighting) {

        } else if (v.getId() == R.id.bt_porterduff) {

        } else if (v.getId() == R.id.bt_colormatrix) {

        } else if (v.getId() == R.id.img) {
            ImageUtil.displayImageSobel(getApplicationContext(), imageView, R.drawable.bg5);
        }
    }
}
