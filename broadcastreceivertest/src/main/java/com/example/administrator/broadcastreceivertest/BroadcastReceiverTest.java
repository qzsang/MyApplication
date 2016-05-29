package com.example.administrator.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/3/20.
 */
public class BroadcastReceiverTest extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {


        Log.e("BroadcastReceiverTest","收到广播:"+intent.getAction());
        Toast.makeText(context,"收到广播:"+intent.getAction(),Toast.LENGTH_SHORT).show();
    }
}
