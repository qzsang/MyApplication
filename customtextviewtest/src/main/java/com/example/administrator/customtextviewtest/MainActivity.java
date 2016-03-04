package com.example.administrator.customtextviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends AppCompatActivity {


    @ViewInject(id = R.id.ctv_view)
    CustomTitleView ctv_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FinalActivity.initInjectedView(this);

    }
}
