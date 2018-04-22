package com.xishuang.imagesizetest.algorithm;

import android.support.annotation.NonNull;

import java.util.Iterator;

/**
 * Author:xishuang
 * Date:2018.04.21
 * Des:链表实现栈(LIFO:后进先出)
 */
public class LinkStack<T> implements Iterable<T> {

    /**
     * 栈顶，指向链表头
     */
    private Node first;

    /**
     * 元素的数量
     */
    private int N;

    /**
     * 链表的节点类
     */
    private class Node {
        T item;
        Node next;
    }

    /**
     * 压栈
     */
    public void push(T item) {
        //往链表头添加元素
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * 弹栈
     */
    public T pop() {
        T item = first.item;
        first = first.next;
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
