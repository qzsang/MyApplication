package com.example.administrator.mycanvastest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mycanvastest.myView.CircleView;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        CircleView circleView = (CircleView) findViewById(R.id.cc_circle_view);
        circleView.setProgress(80);

    }
}
