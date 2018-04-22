package com.xishuang.imagesizetest.algorithm;

import android.support.annotation.NonNull;

import java.util.Iterator;

/**
 * Author:xishuang
 * Date:2018.04.21
 * Des:动态数组实现栈(LIFO:后进先出)
 */
public class ResizeArrayStack<T> implements Iterable<T> {

    /**
     * 存储栈元素的数组
     */
    private T[] arrays = (T[]) new Object[1];

    /**
     * 栈中的元素数量
     */
    private int NUM = 0;

    /**
     * 压栈
     */
    public void push(T item) {
        //如果元素数量已经达到数组大小，需要扩容
        if (NUM == arrays.length) {
            resizeArray(2 * arrays.length);
        }
        arrays[NUM++] = item;
    }

    /**
     * 弹栈
     */
    public T pop() {
        //从栈顶删除元素
        T item = arrays[--NUM];
        //避免对象游离
        arrays[NUM] = null;
        //数组中元素数量小于四分之一可以减容
        if (NUM > 0 && NUM == arrays.length / 4) {
            resizeArray(arrays.length / 2);
        }
        return item;
    }

    /**
     * 需要给数组扩容
     *
     * @param length 扩容后的大小
     */
    private void resizeArray(int length) {
        T[] resizeArrays = (T[]) new Object[length];
        System.arraycopy(arrays, 0, resizeArrays, 0, NUM);
        arrays = resizeArrays;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new ResizeArrayIterator();
    }

    /**
     * 支持后进先出的迭代器
     */
    private class ResizeArrayIterator implements Iterator<T>{
        private int i = NUM;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return arrays[--i];
        }

        @Override
        public void remove() {

        }
    }
}
