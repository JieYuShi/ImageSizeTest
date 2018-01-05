package com.xishuang.imagesizetest.intentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import com.xishuang.imagesizetest.Constants;

/**
 * Created by xishuang on 2018/1/4.
 */

public class MyLocalReceiver extends BroadcastReceiver {

    public MyLocalReceiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) return;
        String extra = intent.getStringExtra(Constants.EXTENDED_DATA_STATUS);
        Toast.makeText(context, extra, Toast.LENGTH_SHORT).show();
    }
}
