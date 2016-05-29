package com.example.administrator.broadcastsend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.qzsangTest");
        sendBroadcast(intent);
    }
}
