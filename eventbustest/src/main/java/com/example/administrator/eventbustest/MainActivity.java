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

//
//onEvent:如果使用onEvent作为订阅函数，那么该事件在哪个线程发布出来的，onEvent就会在这个线程中运行，也就是说发布事件和接收事件线程在同一个线程。使用这个方法时，在onEvent方法中不能执行耗时操作，如果执行耗时操作容易导致事件分发延迟。
//
//        onEventMainThread:如果使用onEventMainThread作为订阅函数，那么不论事件是在哪个线程中发布出来的，onEventMainThread都会在UI线程中执行，接收事件就会在UI线程中运行，这个在Android中是非常有用的，因为在Android中只能在UI线程中跟新UI，所以在onEvnetMainThread方法中是不能执行耗时操作的。
//
//        onEventBackground:如果使用onEventBackgrond作为订阅函数，那么如果事件是在UI线程中发布出来的，那么onEventBackground就会在子线程中运行，如果事件本来就是子线程中发布出来的，那么onEventBackground函数直接在该子线程中执行。
//
//        onEventAsync：使用这个函数作为订阅函数，那么无论事件在哪个线程发布，都会创建新的子线程在执行onEventAsync.