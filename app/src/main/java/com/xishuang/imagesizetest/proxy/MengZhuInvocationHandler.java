package com.xishuang.imagesizetest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author:xishuang
 * Date:2018.02.07
 * Des:具体的代理逻辑实现
 */
public class MengZhuInvocationHandler implements InvocationHandler {

    /**
     * InvocationHandler持有的被代理对象
     */
    private IWuDang mWuDangMan;
    private IShaolin mShaolinMan;

    MengZhuInvocationHandler(IWuDang wuDang, IShaolin shaolin) {
        mWuDangMan = wuDang;
        mShaolinMan = shaolin;
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
        if (method.getName().equals("playTaijiquan")) {
            System.out.println("给自己加戏-动态代理");
            mWuDangMan.playTaijiquan();
        } else if (method.getName().equals("playYiGinChing")) {
            System.out.println("给自己加戏-动态代理");
            mShaolinMan.playYiGinChing();
        }
        return proxy;
    }
}
