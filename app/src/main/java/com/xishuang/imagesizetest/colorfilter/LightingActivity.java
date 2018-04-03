package com.xishuang.imagesizetest.colorfilter;

import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.xishuang.imagesizetest.R;

/**
 * Author:xishuang
 * Date:2018.04.03
 * Des: LightingColorFilter的效果调试界面
 */
public class LightingActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ImageView imageView;
    private SeekBar seekBarPlusR;
    private SeekBar seekBarPlusG;
    private SeekBar seekBarPlusB;
    private SeekBar seekBarAddR;
    private SeekBar seekBarAddG;
    private SeekBar seekBarAddB;
    private TextView tvPlusColorText;
    private TextView tvPlusColor;
    private TextView tvAddColorText;
    private TextView tvAddColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lighting);

        imageView = (ImageView) findViewById(R.id.lighting_img);

        seekBarPlusR = (SeekBar) findViewById(R.id.lighting_plus_bar_R);
        seekBarPlusG = (SeekBar) findViewById(R.id.lighting_plus_bar_G);
        seekBarPlusB = (SeekBar) findViewById(R.id.lighting_plus_bar_B);

        seekBarAddR = (SeekBar) findViewById(R.id.lighting_add_bar_R);
        seekBarAddG = (SeekBar) findViewById(R.id.lighting_add_bar_G);
        seekBarAddB = (SeekBar) findViewById(R.id.lighting_add_bar_B);

        tvPlusColorText = (TextView) findViewById(R.id.lighting_plus_color_text);
        tvPlusColor = (TextView) findViewById(R.id.lighting_plus_color);
        tvAddColorText = (TextView) findViewById(R.id.lighting_add_color_text);
        tvAddColor = (TextView) findViewById(R.id.lighting_add_color);

        seekBarPlusR.setOnSeekBarChangeListener(this);
        seekBarPlusG.setOnSeekBarChangeListener(this);
        seekBarPlusB.setOnSeekBarChangeListener(this);
        seekBarAddR.setOnSeekBarChangeListener(this);
        seekBarAddG.setOnSeekBarChangeListener(this);
        seekBarAddB.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        String plusText = "Plus颜色值：#" + Integer.toHexString(seekBarPlusR.getProgress()) + "-"
                + Integer.toHexString(seekBarPlusG.getProgress()) + "-"
                + Integer.toHexString(seekBarPlusB.getProgress());
        int plusColor = Color.argb(255, seekBarPlusR.getProgress(),
                seekBarPlusG.getProgress(),
                seekBarPlusB.getProgress());
        tvPlusColorText.setText(plusText);
        tvPlusColor.setBackgroundColor(plusColor);

        String addText = "Add颜色值：#" + Integer.toHexString(seekBarAddR.getProgress()) + "-"
                + Integer.toHexString(seekBarAddG.getProgress()) + "-"
                + Integer.toHexString(seekBarAddB.getProgress());
        int addColor = Color.argb(255, seekBarAddR.getProgress(),
                seekBarAddG.getProgress(),
                seekBarAddB.getProgress());
        tvAddColorText.setText(addText);
        tvAddColor.setBackgroundColor(addColor);

        //关键代码，设置LightingColorFilter
        imageView.setColorFilter(new LightingColorFilter(plusColor, addColor));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
