package com.xishuang.imagesizetest.algorithm.sort;

/**
 * Author:xishuang
 * Date:2018.04.22
 * Des:交换排序:冒泡排序，初等排序{@link QuickSort}
 */
public class BubbleSort extends AbsSort {
    @Override
    public void sort(Comparable[] arrays) {
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                //如果arrays[j + 1]小于arrays[j]就交换数据，升序
                if (less(arrays[j + 1], arrays[j])) {
                    exch(arrays, j + 1, j);
                }
            }
        }
    }

    @Override
    protected String getSortName() {
        return "冒泡排序";
    }
}
