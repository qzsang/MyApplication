package com.example.administrator.dialogtest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_jump_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_jump_dialog = (Button) findViewById(R.id.btn_jump_dialog);


        btn_jump_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionSortDialog actionSortDialog = new ActionSortDialog(MainActivity.this, R.style.FillWidthDialog);
                actionSortDialog.setCanceledOnTouchOutside(true);//设置点击Dialog外部任意区域关闭Dialog
                actionSortDialog.getWindow().setWindowAnimations(R.style.PopupAnimation);
                //actionSortDialog.getWindow().setGravity(Gravity.BOTTOM);
                //获得当前窗体
                Window window = actionSortDialog.getWindow();
                //重新设置
                WindowManager.LayoutParams lp = window.getAttributes();
                window .setGravity(Gravity.LEFT | Gravity.BOTTOM);
                lp.x = 0; // 新位置X坐标
                lp.y = 0; // 新位置Y坐标
              //  lp.width = 300; // 宽度
                lp.height = MainActivity.this.getWindowManager().getDefaultDisplay().getHeight(); // 高度
                lp.alpha = 0.7f; // 透明度

// dialog.onWindowAttributesChanged(lp);
//(当Window的Attributes改变时系统会调用此函数)
                window .setAttributes(lp);
                actionSortDialog.show();
            }
        });
    }


}


class ActionSortDialog extends Dialog {
    public ActionSortDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_action_sort);

        findViewById(R.id.tv_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dismiss();//隐藏对话框

            }
        });
    }
}