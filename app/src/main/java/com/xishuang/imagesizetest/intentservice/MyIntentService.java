package com.xishuang.imagesizetest.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.xishuang.imagesizetest.Constants;

/**
 * Author:xishuang
 * Date:2018/1/4
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent == null) return;
        //从Intent中获取数据
        String content = intent.getDataString();
        Log.d("xishuang", content);

        //发送一个本地广播，应用内接收
        Intent localIntent = new Intent();
        localIntent.setAction(Constants.BROADCAST_ACTION);
//        localIntent.setData(Uri.parse(content));
        localIntent.putExtra(Constants.EXTENDED_DATA_STATUS, content);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }
}
