package com.xishuang.imagesizetest.opengles;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;

import com.xishuang.imagesizetest.Constants;
import com.xishuang.imagesizetest.R;
import com.xishuang.imagesizetest.intentservice.MyIntentService;
import com.xishuang.imagesizetest.intentservice.MyLocalReceiver;

/**
 * Author:xishuang
 * Date:2018/1/2.
 */

public class OpenGLES20Activity extends FragmentActivity {

    private MyGLSurfaceView mGLView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FrameLayout layout = (FrameLayout) findViewById(R.id.container);
//        //创建一个GLSurfaceView实例并把加进Activity中
//        mGLView = new MyGLSurfaceView(this);
//        layout.addView(mGLView);
//        setContentView(mGLView);

        //启动IntentService
        Intent intent = new Intent(this, MyIntentService.class);
        intent.setData(Uri.parse("http://www.baidu.com/dalao"));
        startService(intent);

        //接收IntentService处理
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.BROADCAST_ACTION);
        MyLocalReceiver receiver = new MyLocalReceiver();
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
    }
}
