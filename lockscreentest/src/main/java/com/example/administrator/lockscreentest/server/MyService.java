package com.example.administrator.lockscreentest.server;


import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.administrator.lockscreentest.utils.LogUtil;
import com.example.administrator.lockscreentest.widget.LockScreen;

import de.greenrobot.event.EventBus;

public class MyService extends Service {

    LockScreen lockScreen;//锁屏显示的view
    WindowManager windowManager;

    Context context;

    public static final String OPEN_LOCK = "open_lock";
    String TAG = "MyService ";
    BroadcastReceiver broadcastReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplication();
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);


        //注册亮屏广播
        IntentFilter filter = new IntentFilter();
       // filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                //显示屏保
                showlockScreen();
                //隐藏屏保
                if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                    disableKeyguard();
                }
            }
        }, filter);


        //注册EventBus
        EventBus eventBus = EventBus.getDefault();
        eventBus.register(this);

        LogUtil.e(TAG + "onCreate", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null &&
                intent.getAction() != null &&
                intent.getAction().equals(OPEN_LOCK)) {
            showlockScreen();
            disableKeyguard();
        }
        LogUtil.e(TAG + "onStartCommand", "onStartCommand" + intent);
        return Service.START_STICKY;
    }

    //显示锁屏屏幕
    private void showlockScreen() {
        LogUtil.e(TAG + "showlockScreen", lockScreen);
        if (lockScreen == null) {
            lockScreen = new LockScreen(context);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
            );
            layoutParams.format = PixelFormat.RGBA_8888;
            windowManager.addView(lockScreen, layoutParams);

        }




    }
    //隐藏系统锁屏
    private void disableKeyguard() {
        KeyguardManager mKeyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock mKeyguardLock = mKeyguardManager.newKeyguardLock("1");
        mKeyguardLock.disableKeyguard();
    }

    //隐藏锁
    private void hidelockScreen() {
        LogUtil.e(TAG + "hidelockScreen", lockScreen);

        if (lockScreen != null) {
            windowManager.removeView(lockScreen);
            lockScreen = null;
        }

    }

    //接收隐藏屏保事件
    public void onEventMainThread(String msg) {
        Toast.makeText(context, msg + "", Toast.LENGTH_LONG).show();
        hidelockScreen();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);

        EventBus eventBus = EventBus.getDefault();
        eventBus.unregister(this);
        //重启
        startService(new Intent(this, MyService.class));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
