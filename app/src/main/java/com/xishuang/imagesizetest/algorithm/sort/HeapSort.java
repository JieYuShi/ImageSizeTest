package com.xishuang.imagesizetest.algorithm.sort;

/**
 * Author:xishuang
 * Date:2018.04.23
 * Des:选择排序:堆排序{@link SelectSort}
 */
public class HeapSort extends AbsSort {
    /**
     * 堆排序不使用索引为0的位置，从1索引开始
     */
    @Override
    public void sort(Comparable[] arrays) {
        int N = arrays.length - 1;
        //只需要扫描数组中的一半元素，因为可以跳过大小为1的子堆
        //通过下沉构造二叉堆
        for (int k = N / 2; k >= 1; k--) {
            sink(arrays, k, N);
        }
        //将最大的元素arrays[1]和arrays[N]交换并修复堆
        while (N > 1) {
            exch(arrays, 1, N--);
            sink(arrays, 1, N);
        }
    }

    /**
     * 由上至下堆有序化(下沉)
     */
    private void sink(Comparable[] arrays, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            //找到两个字结点中较大的那个
            if (j < N && less(arrays[j], arrays[j + 1])) {
                j++;
            }
            //如果父结点大的话就不需要交换
            if (!less(arrays[k], arrays[j])) {
                break;
            }
            //如果子结点较大，需要和父节点交换，保持二叉堆有序
            exch(arrays, k, j);
            k = j;
        }
    }

    @Override
    protected String getSortName() {
        return "堆排序";
    }
}
