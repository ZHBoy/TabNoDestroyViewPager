package com.example.hao.tabnodestroyviewpager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hao.tabnodestroyviewpager.R;

import java.util.ArrayList;
import java.util.List;

/**
* @作者 hao
* @创建日期 2018/1/26 15:11
* Description: adapter实例
*/
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.MyViewHolder> {
    private List<String> mItems = new ArrayList<>();
    private LayoutInflater mInflater;

    public SimpleAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public void setDatas(List<String> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_pager, parent, false);
        final MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String item = mItems.get(position);
        holder.tvTitle.setText(item);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

}
