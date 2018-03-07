package com.xishuang.imagesizetest.proxy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.xishuang.imagesizetest.R;
import com.xishuang.imagesizetest.jobscheduler.JobSchedulerService;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Author:xishuang
 * Date:2018.02.06
 */
public class ProxyActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_colorfilter);
//        staticProxy();
        daynamicProxy();
    }

    /**
     * 静态代理
     */
    private void staticProxy() {
        MengZhuProxy proxy = new MengZhuProxy();
        proxy.playTaijiquan();
        proxy.playYiGinChing();
    }

    /**
     * 动态代理
     */
    private void daynamicProxy() {
        // 创建一个与代理对象相关联的InvocationHandler
        InvocationHandler handler = new MengZhuInvocationHandler(new WuDangMan(), new ShaoLinMan());
        // 创建一个代理对象studentProxy来代理student，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        IWuDang studentProxy = (IWuDang) Proxy.newProxyInstance(getClassLoader(), new Class[]{IWuDang.class, IShaolin.class}, handler);
        studentProxy.playTaijiquan();
        ((IShaolin) studentProxy).playYiGinChing();
    }
}
