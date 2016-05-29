package com.example.administrator.lockscreentest.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.lockscreentest.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2016/3/20.
 */
public class LockScreen extends RelativeLayout implements View.OnClickListener{

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");//时间密码

    private Context context;
    private View rootView;

    private String password = "";

    int numIds [] = new int[]{
            R.id.tv_num_0,
            R.id.tv_num_1,
            R.id.tv_num_2,
            R.id.tv_num_3,
            R.id.tv_num_4,
            R.id.tv_num_5,
            R.id.tv_num_6,
            R.id.tv_num_7,
            R.id.tv_num_8,
            R.id.tv_num_9};

    private TextView tv_alert;
    private LinearLayout ll_flag;//按键提示
    public LockScreen(Context context) {
        super(context);
        init(context);
    }


    public LockScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {
        this.context = context;
        rootView = View.inflate(
                context,
                R.layout.lock_screen_main,
                this);

        tv_alert = (TextView) rootView.findViewById(R.id.tv_alert);
        ll_flag = (LinearLayout) rootView.findViewById(R.id.ll_flag);


        for (int id : numIds) {
            rootView.findViewById(id).setOnClickListener(this);
        }
        rootView.findViewById(R.id.tv_cancle).setOnClickListener(this);
        rootView.findViewById(R.id.tv_sos).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_cancle:

                closeScreen();
                return;
            case R.id.tv_sos:

                sos();
                return;


        }

        //数字按钮点击事件
        TextView textView = (TextView)v;
        pwInport(textView.getText() + "");
    }

    //密码输入
    private void pwInport(String number) {
        password += number;

        //防止溢出报错
        try {
            ImageView ivFlag = (ImageView) ll_flag.getChildAt(password.length()-1);
            ivFlag.setImageResource(R.mipmap.flag_circle_fill_s);
        }catch (Exception e){}



        if (password.length() == 4) {
            String pw = dateFormat.format(new Date()).toString();
            if (pw.equalsIgnoreCase(password)) {
                tv_alert.setText("密码正确");
                EventBus eventBus = EventBus.getDefault();
                eventBus.post("解锁成功");
            } else {
                tv_alert.setText("密码错误");
                password = "";

                for (int i = 0;i < ll_flag.getChildCount();i++) {
                    ImageView imageView = (ImageView) ll_flag.getChildAt(i);
                    imageView.setImageResource(R.mipmap.flag_circle_s);

                }
            }
        }
    }


    //关闭屏幕
    private void closeScreen() {



        tv_alert.setText("一键锁屏功能待开发");
    }

    //紧急呼叫
    private void sos() {
        tv_alert.setText("sos功能待开发");
    }
}
