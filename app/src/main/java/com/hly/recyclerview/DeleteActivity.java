package com.hly.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/7/19~~~~~~
 * ~~~~~~更改时间:2018/7/19~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class DeleteActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DeleteAdapter adapter;
    private List<String> list;

    private TextView add, delete;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeleteActivity.this,GridActivity.class));
            }
        });


        recyclerView = findViewById(R.id.recycle);

        list = new ArrayList<String>();

        for (int i = 0; i < 30; i++) {
            list.add("11");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new DeleteAdapter(list);

        recyclerView.setAdapter(adapter);


        adapter.setOnCallBackData(new DeleteAdapter.OnCallBackData() {
            @Override
            public void onCallBackData(DeleteAdapter.ViewHolder holder, final int position) {
                TextView delete = holder.itemView.findViewById(R.id.delete);
                TextView add = holder.itemView.findViewById(R.id.add);
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                         list.remove(position);
                         adapter.notifyItemRemoved(position);
                         adapter.notifyItemChanged(0,list.size());

                        Log.d("111111delete",list.toString());
                    }
                });
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    list.add(String.valueOf(position+1));
                    adapter.notifyItemInserted(position+1);



                        Log.d("222222add",list.toString());
                    }
                });
            }
        });

    }


}
