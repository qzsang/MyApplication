package com.example.administrator.lockscreentest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.administrator.lockscreentest.server.MyService;
import com.example.administrator.lockscreentest.utils.LogUtil;

/**
 * Created by Administrator on 2016/3/21.
 */
public class StartServiceReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.e("StartServiceReceiver", "start easemob service on boot");
        Intent intent1 = new Intent(context, MyService.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.setAction(MyService.OPEN_LOCK);
        context.startService(intent1);
    }
}
