package com.example.administrator.eventbustest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.eventbustest.bean.MyEvent;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import de.greenrobot.event.EventBus;

public class SendEventActivity extends AppCompatActivity {

    @ViewInject(id = R.id.txt_1)
    TextView txt_1;

    @ViewInject(id = R.id.btn_1,click = "click")
    Button btn_1;
    @ViewInject(id = R.id.btn_2,click = "click")
    Button btn_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_event);

        init();
    }
    String Tag = "SendEventActivity";
    private void init () {
        FinalActivity.initInjectedView(this);
        //注册EventBus
        EventBus eventBus = EventBus.getDefault();
        Log.i(Tag, "init EventBus :" + eventBus.toString());
        Log.i(Tag,"init Thread id :"+ Thread.currentThread().getId());
        eventBus.register(this);

    }
    //接收事件
    public void onEventMainThread(MyEvent event) {
        Toast.makeText(this, event.toString(), Toast.LENGTH_SHORT).show();
        txt_1.setText(event.toString() + ",");
        Log.i(Tag, "init onEventMainThread id :" + Thread.currentThread().getId());
    }

    public void click (View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                EventBus eventBus = EventBus.getDefault();
                Log.i(Tag, "click EventBus :" + eventBus.toString());
                MyEvent myEvent = new MyEvent();
                myEvent.code = "001";
                myEvent.msg = "来自SendEventActivity的Event";
                eventBus.post(myEvent);
                break;
            case R.id.btn_2:
                startActivity(new Intent(this, SendEvent2Activity.class));
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus eventBus = EventBus.getDefault();
        Log.i(Tag, "onDestroy EventBus :" + eventBus.toString());
        eventBus.unregister(this);
    }
}
