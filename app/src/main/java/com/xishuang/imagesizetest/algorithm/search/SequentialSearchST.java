package com.xishuang.imagesizetest.algorithm.search;

import android.util.Log;

/**
 * Author:xishuang
 * Date:2018.04.26
 * Des:基于无序链表的顺序查找
 */
public class SequentialSearchST<Key, Value> {

    /**
     * 链表首结点
     */
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 根据给定的键，查找关联的值
     */
    public Value get(Key key) {
        for (Node i = first; i != null; i = i.next) {
            if (key.equals(i.key)) {
                return i.value;
            }
        }
        return null;
    }

    /**
     * 查找给定的键，找到就更新其值，否则就新建结点加到链表头
     */
    public void put(Key key, Value value) {
        for (Node i = first; i != null; i = i.next) {
            if (key.equals(i.key)) {
                i.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    public void print() {
        for (Node i = first; i != null; i = i.next) {
            Log.d("查找算法", i.key + ":" + i.value);
        }
    }
}
