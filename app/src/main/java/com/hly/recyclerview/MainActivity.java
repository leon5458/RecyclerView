package com.hly.recyclerview;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> data;
    private HomeAdapter mAdapter;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycle);

        data = new ArrayList<String>();
        /**
         * 模拟假数据data.add 添加进去
         */
        for (int i=0;i<10;i++){
            data.add("111");
        }
//        data.add("1111");
//        data.add("1111");
//        data.add("1111");
//        data.add("1111");
//        data.add("1111");
//        data.add("1111");
//        data.add("1111");
//        data.add("1111");
//        data.add("1111");
//        data.add("1111");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new HomeAdapter(data);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);


         findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Recycler1Activity.class));
            }
        });


         mAdapter.setOnItemClickLitener(new HomeAdapter.OnItemClickLitener() {
             @Override
             public void onItemClick(View view, int position) {
                 Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_LONG).show();
             }

             @Override
             public void onItemLongClick(View view, int position) {
                 Toast.makeText(MainActivity.this,"长按点击",Toast.LENGTH_LONG).show();

             }
         });
    }

}
