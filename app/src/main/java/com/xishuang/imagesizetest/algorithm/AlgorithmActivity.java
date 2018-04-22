package com.xishuang.imagesizetest.algorithm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.xishuang.imagesizetest.R;
import com.xishuang.imagesizetest.algorithm.sort.AbsSort;
import com.xishuang.imagesizetest.algorithm.sort.QuickSort;

import java.util.Iterator;

public class AlgorithmActivity extends AppCompatActivity {

    private TextView mContentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm);
        mContentTv = (TextView) findViewById(R.id.algorithm_content);
//        testBinarySearch();
//        testStack();
//        testQueue();
        testSort();
    }

    private void testSort() {
        Integer[] arrays = new Integer[]{29, 33, 16, 18, 10, 54, 57, 11, 84, 9812, 23, 48, 68, 77, 1};
//        AbsSort sort = new BubbleSort();
//        AbsSort sort = new SelectSort();
//        AbsSort sort = new InsertSort();
//        AbsSort sort = new ShellSort();
//        AbsSort sort = new MergeSort();
//        AbsSort sort = new MergeBUSort();
        AbsSort sort = new QuickSort();
        sort.sort(arrays);
        mContentTv.setText(sort.show(arrays));
    }

    private void testBinarySearch() {
        int[] arrays = new int[]{10, 11, 12, 16, 18, 23, 29, 33, 48, 54, 57, 68, 77, 84, 98};
        Log.d("算法-二分排序", BinarySearch.rank(54, arrays) + "");
        Log.d("算法-二分排序", BinarySearch.rank(64, arrays) + "");
    }

    private void testStack() {
//        ResizeArrayStack<String> stack = new ResizeArrayStack<>();
        LinkStack<String> stack = new LinkStack<>();
        stack.push("我");
        stack.push("是");
        stack.push("大");
        stack.push("傻");
        stack.push("叼");
        stack.push("哈哈");

        String pop = stack.pop();
        Log.d("算法-栈", pop);
        StringBuilder builder = new StringBuilder();
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            pop = (String) iterator.next();
            builder.append(pop);
        }
        mContentTv.setText(builder.toString());
    }


    private void testQueue() {
        LinkQueue<String> queue = new LinkQueue<>();
        queue.enqueue("我");
        queue.enqueue("是");
        queue.enqueue("大");
        queue.enqueue("傻");
        queue.enqueue("叼");
        queue.enqueue("哈哈");

        String pop = queue.dequeue();
        Log.d("算法-栈", pop);
        StringBuilder builder = new StringBuilder();
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            pop = (String) iterator.next();
            builder.append(pop);
        }
        mContentTv.setText(builder.toString());
    }
}
