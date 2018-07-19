package com.hly.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/7/19~~~~~~
 * ~~~~~~更改时间:2018/7/19~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class DeleteAdapter extends RecyclerView.Adapter<DeleteAdapter.ViewHolder> {
    private List<String> list;

    public DeleteAdapter(List<String> list) {
        this.list = list;
    }


    OnCallBackData onCallBackData;

    public void setOnCallBackData(OnCallBackData onCallBackData) {
        this.onCallBackData = onCallBackData;
    }

    public interface OnCallBackData {
        void onCallBackData(ViewHolder holder, int position);

    }


    @NonNull
    @Override
    public DeleteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DeleteAdapter.ViewHolder holder, int position) {

        if (onCallBackData != null) {
            onCallBackData.onCallBackData(holder, position);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
