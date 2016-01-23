package com.example.administrator.eventbustest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.eventbustest.bean.MyEvent;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import de.greenrobot.event.EventBus;

public class SendEvent2Activity extends AppCompatActivity {
    @ViewInject(id = R.id.btn_1,click = "click")
    Button btn_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_event2);

        init();
    }
    String Tag = "SendEvent2Activity";
    private void init () {
        FinalActivity.initInjectedView(this);
        Log.i(Tag, "init Thread id :" + Thread.currentThread().getId());
    }

    public void click(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                Looper.prepare();
//                Toast.makeText(SendEvent2Activity.this,"click",Toast.LENGTH_SHORT).show();
//                Looper.loop();
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                EventBus eventBus = EventBus.getDefault();
                Log.i(Tag, "init EventBus :" + eventBus.toString());
                Log.i(Tag, "click Thread id :" + Thread.currentThread().getId());
                MyEvent myEvent = new MyEvent();
                myEvent.code = "001";
                myEvent.msg = "来自SendEvent2Activity的Event";
                eventBus.post(myEvent);
                eventBus.post(myEvent.msg);
            }
        }).start();


    }

}
