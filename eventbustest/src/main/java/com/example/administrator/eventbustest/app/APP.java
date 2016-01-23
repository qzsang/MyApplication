package com.example.administrator.eventbustest.app;

import android.app.Application;
import android.util.Log;

/**
 * Created by Administrator on 2016/1/23.
 */
public class APP extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("APP","thread id" +Thread.currentThread().getId());
    }
}
