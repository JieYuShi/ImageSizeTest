package com.xishuang.imagesizetest.algorithm.sort;

/**
 * Author:xishuang
 * Date:2018.04.22
 * Des:插入排序:希尔排序，最简单的复杂排序算法{@link InsertSort}
 */
public class ShellSort extends AbsSort {
    @Override
    public void sort(Comparable[] arrays) {
        int length = arrays.length;
        //间隔，跨度
        int h = 1;
        //使用递增序列构造h
        while (h < length / 3) {
            //1, 4, 13, 40, 121, 364, 1094, ...
            h = 3 * h + 1;
        }
        while (h >= 1) {
            //将数组变为h跨度有序
            for (int i = h; i < length; i++) {
                //将arrays[h]插入到arrays[i-1 * h]、arrays[i-2 * h]、arrays[i-3 * h]...中去
                for (int j = i; j >= h && less(arrays[j], arrays[j - h]); j -= h) {
                    exch(arrays, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    @Override
    protected String getSortName() {
        return "希尔排序";
    }
}
