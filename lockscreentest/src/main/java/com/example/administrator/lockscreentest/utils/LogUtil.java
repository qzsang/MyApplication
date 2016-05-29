package com.example.administrator.lockscreentest.utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/3/20.
 */
public class LogUtil {
    private static boolean isOpen = true;


    public static void e(Object TAG,Object msg) {
        if (isOpen)
            Log.e(TAG + "",msg + "");

    }

    public static void open() {
        isOpen = true;
    }

    public static void close() {
        isOpen = false;
    }

}
