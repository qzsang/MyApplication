package com.example.administrator.videotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SurfaceView sv_video;

    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


          sv_video = (SurfaceView) findViewById(R.id.sv_video);
        SingleVideoUtil.preparePlay(sv_video);
        findViewById(R.id.btn_s).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    SingleVideoUtil.play();
                    flag = true;
                } else {
                    SingleVideoUtil.mediaPlayer.start();
                }

            }
        });
        findViewById(R.id.btn_e).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleVideoUtil.release();
            }
        });
    }
}
