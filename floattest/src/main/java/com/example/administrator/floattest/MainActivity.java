package com.example.administrator.floattest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    TextView tv_test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_test = (TextView) findViewById(R.id.tv_test);
        tv_test.setOnTouchListener(new View.OnTouchListener() {
            float flagY = 0;
            boolean flag = true;//标记没有触发滑动事件   滑动到屏幕一半时 触发

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:

                        int distance = (int) (flagY - event.getRawY());
                        if (distance > flagY/2) {//事件触发
                            flag = false;
                            Toast.makeText(getApplication(),"打卡触发",Toast.LENGTH_SHORT).show();
                            tv_test.setPadding(0, 0, 0, 0);
                        }
                        if (flag) {
                            tv_test.setPadding(0, 0, 0, distance);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        tv_test.setPadding(0,0,0,0);
                        flag = true;
                        Log.e("ACTION_UP","ACTION_UP");
                        break;
                    case MotionEvent.ACTION_DOWN:
                            flagY =  event.getRawY();
                            Log.e("flagY",flagY +"");
                        Log.e("ACTION_MOVE",event.getY() +"");
                        break;
                    default:

                }



                return true;
            }
        });


    }

    public int getStatusHeight() {

        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, sbar = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = getResources().getDimensionPixelSize(x);
            return sbar;
        } catch(Exception e1) {
            Log.e("Exception","get status bar height fail");
            e1.printStackTrace();
        }
        return 0;
    }
}
