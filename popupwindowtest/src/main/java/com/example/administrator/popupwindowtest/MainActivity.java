package com.example.administrator.popupwindowtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //自定义的弹出框类
    SelectPicPopupWindow menuWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.txt).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //实例化SelectPicPopupWindow
                menuWindow = new SelectPicPopupWindow(MainActivity.this, itemsOnClick);
                //显示窗口
                menuWindow.showAtLocation(MainActivity.this.findViewById(R.id.txt), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
            }
        });
    }

    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener(){

        public void onClick(View v) {
            menuWindow.dismiss();
            switch (v.getId()) {
                case R.id.btn_clear_img:
                    break;
                case R.id.btn_clear_video:
                    break;
                default:
                    break;
            }


        }

    };
}
