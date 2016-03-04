package com.example.administrator.recyclerviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        List<String> list = new ArrayList<String>();
        for (int i = 0;i < 20;i++) {
            list.add(i,"position"+ i);
        }
        RecyclerViewAdapter recyclerViewAdapter =
                new RecyclerViewAdapter(this,list);


        // 创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置垂直滚动，也可以设置横向滚动
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //RecyclerView设置布局管理器
       // rv_list.setLayoutManager(layoutManager);
//另外两种显示模式
        //   rv_list.setLayoutManager(new GridLayoutManager(this, 2)); //Grid视图
       //  rv_list.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL)); //这里用线性宫格显示 类似于瀑布流

        rv_list.setLayoutManager(layoutManager);

        rv_list.setAdapter(recyclerViewAdapter);

    }
}
