package com.example.administrator.ymtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateResponse;
import com.umeng.update.UpdateStatus;

public class MainActivity extends BaseActivity {


    EditText et_username;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Contanst.activities.add(this);
        inint();

        //自动更新提示
//        UmengUpdateAgent.update(this);
//        UmengUpdateAgent.setUpdateOnlyWifi(false);

    }

    private void inint() {
        et_username = (EditText) findViewById(R.id.et_username);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UmengUpdateAgent.setUpdateAutoPopup(false);
                UmengUpdateAgent.setUpdateListener(new UmengUpdateListener() {
                    @Override
                    public void onUpdateReturned(int updateStatus, UpdateResponse updateInfo) {
                        switch (updateStatus) {
                            case UpdateStatus.Yes: // has update
                                UmengUpdateAgent.startDownload(MainActivity.this, updateInfo);
                                break;
                            case UpdateStatus.No: // has no update
                                Toast.makeText(MainActivity.this, "没有更新", Toast.LENGTH_SHORT).show();
                                break;
                            case UpdateStatus.NoneWifi: // none wifi
                                Toast.makeText(MainActivity.this, "没有wifi连接， 只在wifi下更新", Toast.LENGTH_SHORT).show();
                                break;
                            case UpdateStatus.Timeout: // time out
                                Toast.makeText(MainActivity.this, "超时", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
                UmengUpdateAgent.update(MainActivity.this);


//                MobclickAgent.onProfileSignIn(et_username.getText().toString());
//                startActivity(new Intent(MainActivity.this, ContentActivity.class));
            }
        });
    }


}
