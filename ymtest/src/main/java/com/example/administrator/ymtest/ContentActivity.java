package com.example.administrator.ymtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.umeng.onlineconfig.OnlineConfigAgent;
import com.umeng.onlineconfig.OnlineConfigLog;
import com.umeng.onlineconfig.UmengOnlineConfigureListener;

import org.json.JSONObject;

public class ContentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Contanst.activities.add(this);




        UmengOnlineConfigureListener configureListener = new UmengOnlineConfigureListener() {
            @Override
            public void onDataReceived(JSONObject json) {
                // TODO Auto-generated method stub
                OnlineConfigLog.d("OnlineConfig", "json=" + json);
                alert("json=" + json);
            }
        };

        OnlineConfigAgent.getInstance().setOnlineConfigListener(configureListener);
    }


    public void getParams(View v) {
        //在应用的主Activity onCreate() 函数中请求在线参数
        OnlineConfigAgent.getInstance().updateOnlineConfig(getApplicationContext());
       // String value = OnlineConfigAgent.getInstance().getConfigParams(this, "test");
        //alert(value);
    }

    public void nextActivity(View v) {
//        MobclickAgent.onEvent(ContentActivity.this, "tt");
//        Toast.makeText(this,"tt",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LogoutActivity.class));
    }


    public void alert(final String value) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(
                        ContentActivity.this.getApplication(),
                        value + "",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }
}
