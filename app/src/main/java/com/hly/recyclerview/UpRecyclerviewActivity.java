package com.hly.recyclerview;
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
public class UpRecyclerviewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private MyAdapter myAdapter;

    private List<String> list;

    private FloatingActionButton fab;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.up_recyclerview_activity_layout);

        list = new ArrayList<String>();

        fab = findViewById(R.id.fab);

        for (int i = 0; i < 60; i++) {
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

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //获得recyclerView的线性布局管理器
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //获取到第一个item的显示的下标  不等于0表示第一个item处于不可见状态 说明列表没有滑动到顶部 显示回到顶部按钮
                int firstVisibleItemPosition = manager.findFirstVisibleItemPosition();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // 判断是否滚动超过一屏
                    if (firstVisibleItemPosition == 0) {
                        fab.setVisibility(View.GONE);
                    } else {
                        //显示回到顶部按钮
                        fab.setVisibility(View.VISIBLE);
                    }
                    //获取RecyclerView滑动时候的状态
                } else if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {//拖动中
                    fab.setVisibility(View.GONE);
                }

            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              mRecyclerView.smoothScrollToPosition(0);//二者都可以
//                mRecyclerView.scrollToPosition(0);
            }
        });

    }
}
