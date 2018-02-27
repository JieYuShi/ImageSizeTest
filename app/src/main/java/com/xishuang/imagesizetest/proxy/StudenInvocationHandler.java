package com.xishuang.imagesizetest.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author:xishuang
 * Date:2018.02.07
 * Des:具体的代理逻辑实现
 */
public class StudenInvocationHandler implements InvocationHandler {

    /**
     * InvocationHandler持有的被代理对象
     */
    private Person target;

    StudenInvocationHandler(Person target) {
        this.target = target;
    }

    /**
     * 进行具体的代理操作
     *
     * @param proxy  所代理的类
     * @param method 正在调用得方法
     * @param args   方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.d("息霜", "class:" + proxy.getClass().getName() + " method:" + method.getName());
        if (method.getName().equals("submitMoney")) {
            //代理过程中插入监测方法,计算该方法耗时
            MonitorUtil.start();
            method.invoke(target, args);
            MonitorUtil.finish(method.getName());
        }
        return proxy;
    }
}
