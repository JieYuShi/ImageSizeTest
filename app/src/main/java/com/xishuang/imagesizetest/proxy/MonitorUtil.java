package com.xishuang.imagesizetest.proxy;

import android.util.Log;

/**
 * Created by xishuang on 2018/2/7.
 */

public class MonitorUtil {
    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        Log.d("息霜", methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}
