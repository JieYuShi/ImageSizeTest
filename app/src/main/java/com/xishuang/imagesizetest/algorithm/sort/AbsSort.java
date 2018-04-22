package com.xishuang.imagesizetest.algorithm.sort;

import android.util.Log;

/**
 * Author:xishuang
 * Date:2018.04.22
 * Des:排序算法的抽象类
 */
public abstract class AbsSort {

    public abstract void sort(Comparable[] arrays);

    protected abstract String getSortName();

    /**
     * 比较大小，小于
     */
    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中的元素
     */
    protected void exch(Comparable[] arrays, int i, int j) {
        Comparable temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public String show(Comparable[] arrays) {
        StringBuilder builder = new StringBuilder(getSortName());
        for (int i = 0; i < arrays.length; i++) {
            builder.append(arrays[i] + " ");
        }
        Log.d("算法-排序", builder.toString());
        return builder.toString();
    }
}
