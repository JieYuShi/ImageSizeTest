package com.xishuang.imagesizetest.algorithm.sort;

/**
 * Author:xishuang
 * Date:2018.04.22
 * Des:插入排序:简单插入排序，初等排序{@link ShellSort}
 */
public class InsertSort extends AbsSort {
    @Override
    public void sort(Comparable[] arrays) {
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            //将arrays[i]插入到arrays[i-1]、arrays[i-2]、arrays[i-3]...中去
            for (int j = i; j > 0 && less(arrays[j], arrays[j - 1]); j--) {
                exch(arrays, j, j - 1);
            }
        }
    }

    @Override
    protected String getSortName() {
        return "简单插入排序";
    }
}
