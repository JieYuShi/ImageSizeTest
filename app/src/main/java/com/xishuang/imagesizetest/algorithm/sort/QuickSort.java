package com.xishuang.imagesizetest.algorithm.sort;

/**
 * Author:xishuang
 * Date:2018.04.22
 * Des:交换排序:快速排序{@link BubbleSort}
 */
public class QuickSort extends AbsSort {
    @Override
    public void sort(Comparable[] arrays) {
        sort(arrays, 0, arrays.length - 1);
    }

    private void sort(Comparable[] arrays, int low, int high) {
        if (high <= low) return;
        //进行切分
        int j = partition(arrays, low, high);
        //将左半部分arrays[low..j-1]进行排序
        sort(arrays, low, j - 1);
        //将右半部分arrays[j+1..high]进行排序
        sort(arrays, j + 1, high);
    }

    /**
     * 将数组切分为arrays[low..i-1], arrays[i], arrays[i+1..high]
     */
    private int partition(Comparable[] arrays, int low, int high) {
        //左右扫描指针
        int i = low, j = high + 1;
        //切分元素
        Comparable v = arrays[low];
        while (true) {
            //扫描左右，检查扫描是否结束并交换元素
            while (less(arrays[++i], v)) {
                if (i == high) break;
            }
            while (less(v, arrays[--j])) {
                if (j == low) break;
            }
            if (i >= j) break;
            exch(arrays, i, j);
        }
        //将v = arrays[j]放入正确的位置
        exch(arrays, low, j);
        //arrays[low..i-1] <= arrays[i] <= arrays[i+1..high]达成
        return j;
    }

    @Override
    protected String getSortName() {
        return "快速排序";
    }
}
