package com.xishuang.imagesizetest.algorithm.sort;

/**
 * Author:xishuang
 * Date:2018.04.22
 * Des:归并排序，自底向上，先归并微型数组，然后归并子数组
 */
public class MergeBUSort extends AbsSort {
    /**
     * 辅助数组
     */
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] arrays) {
        //进行lgN次两两归并
        int N = arrays.length;
        aux = new Comparable[N];
        //sz子数组的大小
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int low = 0; low < N - sz; low += sz + sz) {
                merge(arrays, low, low + sz - 1, Math.min(low + sz + sz - 1, N - 1));
            }
        }
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
        return "自底向上归并排序";
    }
}
