package com.xishuang.imagesizetest.dragrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xishuang.imagesizetest.R;

import java.util.Collections;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomeViewHolder> implements RecycleItemTouchHelper.ItemTouchHelperCallback {

    private Context context;
    private List<String> list;

    public CustomAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public CustomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.alc_card_manager_item_editable, parent, false);
        return new CustomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomeViewHolder holder, final int position) {
        holder.item_textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onItemDelete(int positon) {
        list.remove(positon);
        notifyItemRemoved(positon);
    }

    @Override
    public void onMove(int fromPosition, int toPosition) {
        Collections.swap(list, fromPosition, toPosition);//交换数据
        notifyItemMoved(fromPosition, toPosition);
    }

    public class CustomeViewHolder extends RecyclerView.ViewHolder {


        TextView item_textView;
        View item_bg;

        public CustomeViewHolder(View itemView) {
            super(itemView);
            item_textView = (TextView) itemView.findViewById(R.id.alc_card_manager_item_name_text);
            item_bg = itemView.findViewById(R.id.alc_card_manager_item_layout);
        }

    }
}
