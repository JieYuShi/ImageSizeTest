package com.xishuang.imagesizetest.proxy;

/**
 * Created by xishuang on 2018/2/7.
 */

public class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void submitMoney() {
        try {
            //假设数钱花了一秒时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上交班费50元");
    }

    @Override
    public void doHomeWork() {
        System.out.println(name + "写作业");
    }
}
