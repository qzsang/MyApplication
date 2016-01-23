package com.example.administrator.hxtest.app;

import android.app.Application;
import android.content.Context;

import com.easemob.chat.EMChat;

/**
 * Created by Administrator on 2016/1/22.
 */
public class APP extends Application {

    private static Context context = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        //环信
        EMChat.getInstance().init(context);
        EMChat.getInstance().setDebugMode(true);//在做打包混淆时，要关闭debug模式，避免消耗不必要的资源

    }
    public static Context getAPPContext () {
        return context;
    }

}
