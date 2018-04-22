package com.xishuang.imagesizetest.algorithm;

import android.support.annotation.NonNull;

import java.util.Iterator;

/**
 * Author:xishuang
 * Date:2018.04.21
 * Des:链表实现队列(FIFO:先进先出)
 */
public class LinkQueue<T> implements Iterable<T> {

    /**
     * 指向链表头，代表最早添加的元素
     */
    private Node first;
    /**
     * 指向链表尾，代表刚刚最新添加的元素
     */
    private Node last;

    /**
     * 元素数量
     */
    private int N;

    private class Node {
        T item;
        Node next;
    }

    private boolean isEmpty() {
        return first == null;
    }

    /**
     * 添加元素，加入到链尾
     */
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    /**
     * 从链表的表头删除一个元素返回
     */
    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new LinkIterator();
    }

    /**
     * 迭代器
     */
    private class LinkIterator implements Iterator<T> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
