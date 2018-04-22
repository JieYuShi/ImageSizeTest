package com.xishuang.imagesizetest.algorithm.sort;

/**
 * Author:xishuang
 * Date:2018.04.22
 * Des:归并排序，自顶向下，分治思想，大而化小，将两个有序数组合并到第三个数组
 */
public class MergeSort extends AbsSort {

    /**
     * 辅助数组
     */
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] arrays) {
        aux = new Comparable[arrays.length];
        sort(arrays, 0, arrays.length - 1);
    }

    /**
     * 将数组arrays[low..high]排序
     */
    private void sort(Comparable[] arrays, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        //将左半边排序
        sort(arrays, low, mid);
        //将右半边排序
        sort(arrays, mid + 1, high);
        //归并结果
        merge(arrays, low, mid, high);
    }

    /**
     * 原地归并数组，将arrays[low..mid]和arrays[mid+1..high]归并
     */
    private void merge(Comparable[] arrays, int low, int mid, int high) {
        int i = low, j = mid + 1;
        //将arrays[low..high]复制到aux[low..high]
        for (int k = low; k <= high; k++) {
            aux[k] = arrays[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                arrays[k] = aux[j++];
            } else if (j > high) {
                arrays[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                arrays[k] = aux[j++];
            } else {
                arrays[k] = aux[i++];
            }
        }
    }

    @Override
    protected String getSortName() {
        return "自顶向下归并排序";
    }
}
