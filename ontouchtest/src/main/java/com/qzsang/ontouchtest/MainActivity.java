package com.qzsang.ontouchtest;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    TestGroupView gv_group_view;
    TestView tv_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_view = (TestView) findViewById(R.id.tv_view);
        gv_group_view = (TestGroupView) findViewById(R.id.gv_group_view);
    }
}
