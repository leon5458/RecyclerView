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
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/7/18~~~~~~
 * ~~~~~~更改时间:2018/7/18~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class Recycler1Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private MyAdapter myAdapter;

    private List<String> list;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler1_activity_layout);

        list = new ArrayList<String>();

        for (int i = 0; i < 30; i++) {
            list.add("2222");
        }

        //通过findViewById拿到RecyclerView实例
        mRecyclerView = findViewById(R.id.recycle);

        //设置RecyclerView管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // 设置分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //初始化适配器 并绑定数据
        myAdapter = new MyAdapter(list);

        //设置添加或删除item时的动画，这里使用默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //设置适配器
        mRecyclerView.setAdapter(myAdapter);



        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Recycler1Activity.this,Recycler2Activity.class));
            }
        });


    }
}
