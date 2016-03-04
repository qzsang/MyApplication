package com.example.administrator.hxtest.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.easemob.EMCallBack;
import com.easemob.EMError;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;
import com.easemob.exceptions.EaseMobException;
import com.example.administrator.hxtest.R;
import com.example.administrator.hxtest.app.APP;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends Activity {

    @ViewInject(id = R.id.btn_register,click = "click")
    Button btn_register;
    @ViewInject(id = R.id.btn_login,click = "click")
    Button btn_login;
    @ViewInject(id = R.id.btn_register_user_group,click = "click")
    Button btn_register_user_group;
    @ViewInject(id = R.id.et_user)
    EditText et_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FinalActivity.initInjectedView(this);
        et_user.setText("qzsang");
    }

    public void click (View v) {
        final String user = et_user.getText().toString();
        switch (v.getId()) {
            case R.id.btn_register :
                rigister(user);

                    break;
            case R.id.btn_login :
                EMChatManager.getInstance().login(user,"123456",new EMCallBack() {//回调
                    @Override
                    public void onSuccess() {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                EMGroupManager.getInstance().loadAllGroups();
                                EMChatManager.getInstance().loadAllConversations();
                                Log.d("main", "登陆聊天服务器成功！");
                                handler.sendEmptyMessage(0);
                            }
                        });
                    }

                    @Override
                    public void onProgress(int progress, String status) {

                    }

                    @Override
                    public void onError(int code, String message) {

                        Log.e("main login onError", "code:"+code+"," +message);
                        Log.e("main", "登陆聊天服务器失败！");
                    }
                });
                break;

            case R.id.btn_register_user_group :
                String userName = "test";
                for (int i = 0;i < 10;i++) {
                    String t = userName + i;
                    rigister(t);
                    Toast.makeText(APP.getAPPContext(), "注册" + t, Toast.LENGTH_SHORT).show();

                }
                break;


        }

    }

    //注册
    private void rigister (final String user) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 调用sdk注册方法
                    EMChatManager.getInstance().createAccountOnServer(user, "123456");
                } catch (final EaseMobException e) {
                    //注册失败
                    int errorCode = e.getErrorCode();
                    if (errorCode == EMError.NONETWORK_ERROR) {
                        Toast.makeText(APP.getAPPContext(), "网络异常，请检查网络！", Toast.LENGTH_SHORT).show();
                    } else if (errorCode == EMError.USER_ALREADY_EXISTS) {
                        Toast.makeText(APP.getAPPContext(), "用户已存在！", Toast.LENGTH_SHORT).show();
                    } else if (errorCode == EMError.UNAUTHORIZED) {
                        Toast.makeText(APP.getAPPContext(), "注册失败，无权限！", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(APP.getAPPContext(), "注册失败: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }).start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            MainActivity.this.startActivity(new Intent(MainActivity.this,UserListActivity.class));
        }
    };
}
