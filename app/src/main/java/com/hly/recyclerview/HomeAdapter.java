package com.hly.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/7/18~~~~~~
 * ~~~~~~更改时间:2018/7/18~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<String> data;

    public HomeAdapter(List<String> data) {
        this.data = data;
    }

    //定义接口
    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    //声明接口变量
    private OnItemClickLitener mOnItemClickLitener;

    //set方法
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent,
                false));
        return holder;


    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
//        holder.tv.setText(data.get(position));
//        holder.tv1.setText(data.get(position));
//        holder.icon.setImageResource(Integer.parseInt(data.get(position)));

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
//        TextView tv;
//        TextView tv1;
//        ImageView icon;

        public ViewHolder(View view) {
            super(view);
//            tv = view.findViewById(R.id.id_num);
//            tv1 = view.findViewById(R.id.id_tv);
//            icon = view.findViewById(R.id.id_icon);
        }
    }
}