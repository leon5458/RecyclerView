package com.hly.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/7/19~~~~~~
 * ~~~~~~更改时间:2018/7/19~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class GridActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GridAdapter adapter;
    private List<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);

        list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add("");
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(this, R.dimen.dp_5);
        recyclerView.addItemDecoration(itemOffsetDecoration);
        adapter = new GridAdapter(list);

        recyclerView.setAdapter(adapter);


        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GridActivity.this,UpRecyclerviewActivity.class));
            }
        });
    }
}
