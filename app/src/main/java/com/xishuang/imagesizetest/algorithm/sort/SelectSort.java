package com.xishuang.imagesizetest.algorithm.sort;

/**
 * Author:xishuang
 * Date:2018.04.22
 * Des:选择排序:简单选择排序，初等排序{@link HeapSort}
 */
public class SelectSort extends AbsSort {
    @Override
    public void sort(Comparable[] arrays) {
        //按升序排序
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            //将arrays[i]和arrays[i+1..N]中最小的元素交换
            //最小元素的索引
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(arrays[j], arrays[min])) {
                    min = j;
                }
            }
            //把找到的最小元素和开始索引元素交换
            exch(arrays, i, min);
        }
    }

    @Override
    protected String getSortName() {
        return "简单选择排序";
    }
}
