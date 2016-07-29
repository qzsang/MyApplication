package com.example.administrator.lockscreentest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.administrator.lockscreentest.R;
import com.example.administrator.lockscreentest.server.MyService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this,"服务已开启",Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"服务已启动，锁屏后就能看到效果",Toast.LENGTH_LONG).show();
                //启动锁屏
                startService(new Intent(MainActivity.this, MyService.class));
                finish();

            }
        });
    }


}
