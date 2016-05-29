package com.example.administrator.ymtest;

import android.app.Application;

import com.umeng.analytics.MobclickAgent;
import com.umeng.onlineconfig.OnlineConfigAgent;

/**
 * Created by Administrator on 2016/3/14.
 */
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //开启友盟加密
        //   AnalyticsConfig.enableEncrypt(true);
        //启动测试服务
        MobclickAgent.setDebugMode(true);

        //开启调试模式
        OnlineConfigAgent.getInstance().setDebugMode(true);


    }
}
