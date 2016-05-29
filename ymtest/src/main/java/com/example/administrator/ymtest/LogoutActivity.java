package com.example.administrator.ymtest;

import android.os.Bundle;
import android.view.View;

import com.umeng.analytics.MobclickAgent;

public class LogoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        Contanst.activities.add(this);
    }

    public void logout(View v) {
        MobclickAgent.onProfileSignOff();
        Contanst.logout();
    }
}
