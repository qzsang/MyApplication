package com.example.administrator.finalbitmaptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends AppCompatActivity {

    @ViewInject(id = R.id.iv_img)
    ImageView iv_img;
    String url = "http://pic14.nipic.com/20110522/7411759_164157418126_2.jpg";
    FinalBitmap finalBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FinalActivity.initInjectedView(this);
        init();
    }

    public void init() {
        finalBitmap = FinalBitmap.create(this);
        finalBitmap.display(iv_img,url);

    }


}
