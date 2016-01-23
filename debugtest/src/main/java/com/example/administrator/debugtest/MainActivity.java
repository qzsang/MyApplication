package com.example.administrator.debugtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    @ViewInject(id = R.id.txt)
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FinalActivity.initInjectedView(this);
        int a = 6;
        int b = 3;
        int c = sum(a,b);
        txt.setText(c +"");
    }


    public int sum(int a, int b) {
        int temp = a + b;
        return temp;
    }

    public int test(int a) {
        int temp = a + 20;

        return temp;
    }


    private HashMap<Integer,Boolean> praiseMap = new HashMap<Integer,Boolean>();

    public Boolean getHash(Integer a) {
        return praiseMap.get(a);
    }
    private  void putHash(final Integer key,Boolean value) {
        praiseMap.put(key,value);
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                praiseMap.remove(key);
            }
        },10000);
    }

}
