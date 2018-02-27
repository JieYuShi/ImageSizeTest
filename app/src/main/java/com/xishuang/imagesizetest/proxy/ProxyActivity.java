package com.xishuang.imagesizetest.proxy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.xishuang.imagesizetest.R;
import com.xishuang.imagesizetest.jobscheduler.JobSchedulerService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by xishuang on 2018/2/6.
 */
public class ProxyActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_colorfilter);
        // 创建需要代理的对象
        Person student = new Student("嘻嘻");
        // 创建一个与代理对象相关联的InvocationHandler
        InvocationHandler handler = new StudenInvocationHandler(student);
        // 创建一个代理对象studentProxy来代理student，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person studentProxy = (Person) Proxy.newProxyInstance(getClassLoader(), new Class[]{Person.class}, handler);
        studentProxy.submitMoney();
        studentProxy.doHomeWork();
    }
}
