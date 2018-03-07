package com.xishuang.imagesizetest.proxy;

/**
 * Author:xishuang
 * Date:2018.02.06
 * Des:静态代理需要的代理类，编译器就已经确定
 */
public class MengZhuProxy implements IWuDang, IShaolin {
    private IWuDang mWuDangMan;
    private IShaolin mShaolinMan;

    public MengZhuProxy() {
        mWuDangMan = new WuDangMan();
        mShaolinMan = new ShaoLinMan();
    }

    @Override
    public void playYiGinChing() {
        System.out.println("给自己加戏");
        mShaolinMan.playYiGinChing();
    }

    @Override
    public void playTaijiquan() {
        System.out.println("给自己加戏");
        mWuDangMan.playTaijiquan();
    }
}
