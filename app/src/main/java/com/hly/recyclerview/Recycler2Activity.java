package com.hly.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
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
public class Recycler2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VerAdapter verAdapter;
    private List<String> list;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycle);

        list = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            list.add("");
        }

        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        verAdapter = new VerAdapter(list);
        recyclerView.setAdapter(verAdapter);


        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Recycler2Activity.this,Recycler3Activity.class));
            }
        });
    }
}
