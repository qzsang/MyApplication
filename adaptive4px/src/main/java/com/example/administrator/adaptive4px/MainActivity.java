package com.example.administrator.adaptive4px;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends Activity {


    @ViewInject(id = R.id.btn_adaptive)
    Button btn_adaptive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
