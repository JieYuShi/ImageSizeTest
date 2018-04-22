package com.xishuang.imagesizetest.algorithm;

/**
 * Author:xishuang
 * Date:2018.04.21
 * Des二分查找算法
 */
public class BinarySearch {
    /**
     * 二分查找
     *
     * @param key   要查找的数
     * @param array 查找的数据源，必须有序
     * @return 是否命中
     */
    public static int rank(int key, int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
