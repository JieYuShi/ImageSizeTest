//package com.xishuang.imagesizetest.proxy;
//
//import sun.misc.ProxyGenerator;
//
//import java.io.FileOutputStream;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Proxy;
//
//public class MainEntry {
//    public static void main(String[] args) {
//
////        staticProxy();
//
//        daynamicProxy();
//    }
//
//    /**
//     * 静态代理
//     */
//    private static void staticProxy() {
//        MengZhuProxy proxy = new MengZhuProxy();
//        proxy.playTaijiquan();
//        proxy.playYiGinChing();
//    }
//
//    /**
//     * 动态代理
//     */
//    private static void daynamicProxy() {
//        // 创建一个与代理对象相关联的InvocationHandler
//        InvocationHandler handler = new MengZhuInvocationHandler(new WuDangMan(), new ShaoLinMan());
//        // 创建一个代理对象studentProxy来代理student，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
//        IWuDang studentProxy = (IWuDang) Proxy.newProxyInstance(IWuDang.class.getClassLoader(), new Class[]{IWuDang.class, IShaolin.class}, handler);
//        studentProxy.playTaijiquan();
//        ((IShaolin) studentProxy).playYiGinChing();
//
//        generyClass();
//    }
//
//    private static void generyClass() {
//        byte[] classFile = ProxyGenerator.generateProxyClass("GenerateProxy", new Class[]{IWuDang.class, IShaolin.class});
//        String path = "D:/项目/proxyTest/GenerateProxy.class";
//        try (FileOutputStream fos = new FileOutputStream(path)) {
//            fos.write(classFile);
//            fos.flush();
//            System.out.println("代理类class文件写入成功");
//        } catch (Exception e) {
//            System.out.println("写文件错误");
//        }
//    }
//}
