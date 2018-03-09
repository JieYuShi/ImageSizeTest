package com.xishuang.imagesizetest.dragrecycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.ViewGroup;

import com.xishuang.imagesizetest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:xishuang
 * Date:2018.03.09
 */
public class DragRecycleViewActivity extends Activity {

    private CustomAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragrecycleview);
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.drag_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("测试" + i);
        }
        adapter = new CustomAdapter(this, strings);
        recyclerView.setAdapter(adapter);
        ItemTouchHelper.Callback callback = new RecycleItemTouchHelper(getApplicationContext(), adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
