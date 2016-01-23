package com.example.administrator.eventbustest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.eventbustest.bean.MyEvent;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import de.greenrobot.event.EventBus;

public class MainActivity extends Activity {

    @ViewInject(id = R.id.txt_1)
    TextView txt_1;
    @ViewInject(id = R.id.txt_2)
    TextView txt_2;
    @ViewInject(id = R.id.txt_3)
    TextView txt_3;
    @ViewInject(id = R.id.btn_1,click = "click")
    Button btn_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    String Tag = "MainActivity";
    private void init () {
        FinalActivity.initInjectedView(this);
        //注册EventBus
        EventBus eventBus = EventBus.getDefault();
        Log.i(Tag,"init EventBus :"+ eventBus.toString());
        Log.i(Tag,"init Thread id :"+ Thread.currentThread().getId());
        eventBus.register(this);

    }

    //接收事件
    public void onEventMainThread(MyEvent event) {
        Toast.makeText(this,event.toString(),Toast.LENGTH_SHORT).show();
        txt_1.setText(event.toString() + ",");
        Log.i(Tag, "onEventMainThread Thread id :" + Thread.currentThread().getId());
    }

    //接收事件
    public void onEventMainThread(String event) {
        Toast.makeText(this,event.toString(),Toast.LENGTH_SHORT).show();
        txt_2.setText(event.toString() + ",");
        Log.i(Tag, "onEventMainThread Thread id :" + Thread.currentThread().getId());
    }

    public void click (View v) {
        startActivity(new Intent(this,SendEventActivity.class));
    }
    //注销监听
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus eventBus = EventBus.getDefault();
        Log.i(Tag,"onDestroy EventBus :"+ eventBus.toString());
        eventBus.unregister(this);
    }
}
