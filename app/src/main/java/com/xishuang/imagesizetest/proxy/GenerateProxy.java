//package com.xishuang.imagesizetest.proxy;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.lang.reflect.UndeclaredThrowableException;
//
//public final class GenerateProxy extends Proxy implements IWuDang, IShaolin {
//    private static Method m1;
//    private static Method m3;
//    private static Method m2;
//    private static Method m4;
//    private static Method m0;
//
//    public GenerateProxy(InvocationHandler var1) throws {
//        super(var1);
//    }
//
//    public final boolean equals(Object var1) throws  {
//        try {
//            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
//        } catch (RuntimeException | Error var3) {
//            throw var3;
//        } catch (Throwable var4) {
//            throw new UndeclaredThrowableException(var4);
//        }
//    }
//
//    public final void playTaijiquan() throws  {
//        try {
//            super.h.invoke(this, m3, (Object[])null);
//        } catch (RuntimeException | Error var2) {
//            throw var2;
//        } catch (Throwable var3) {
//            throw new UndeclaredThrowableException(var3);
//        }
//    }
//
//    public final String toString() throws  {
//        try {
//            return (String)super.h.invoke(this, m2, (Object[])null);
//        } catch (RuntimeException | Error var2) {
//            throw var2;
//        } catch (Throwable var3) {
//            throw new UndeclaredThrowableException(var3);
//        }
//    }
//
//    public final void playYiGinChing() throws  {
//        try {
//            super.h.invoke(this, m4, (Object[])null);
//        } catch (RuntimeException | Error var2) {
//            throw var2;
//        } catch (Throwable var3) {
//            throw new UndeclaredThrowableException(var3);
//        }
//    }
//
//    public final int hashCode() throws  {
//        try {
//            return (Integer)super.h.invoke(this, m0, (Object[])null);
//        } catch (RuntimeException | Error var2) {
//            throw var2;
//        } catch (Throwable var3) {
//            throw new UndeclaredThrowableException(var3);
//        }
//    }
//
//    static {
//        try {
//            // 通过反射机制来调用各个方法，动态代理会对运行期间的性能造成一定影响
//            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
//            m3 = Class.forName("IWuDang").getMethod("playTaijiquan");
//            m2 = Class.forName("java.lang.Object").getMethod("toString");
//            m4 = Class.forName("IShaolin").getMethod("playYiGinChing");
//            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
//        } catch (NoSuchMethodException var2) {
//            throw new NoSuchMethodError(var2.getMessage());
//        } catch (ClassNotFoundException var3) {
//            throw new NoClassDefFoundError(var3.getMessage());
//        }
//    }
//}