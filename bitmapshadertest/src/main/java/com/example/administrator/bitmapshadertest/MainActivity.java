package com.example.administrator.bitmapshadertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private RoundImageView mQiQiu;
    private RoundImageView mMeiNv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQiQiu = (RoundImageView) findViewById(R.id.id_qiqiu);
        mMeiNv = (RoundImageView) findViewById(R.id.id_meinv);

        mQiQiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQiQiu.setType(RoundImageView.TYPE_ROUND);
            }
        });

        mMeiNv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mMeiNv.setBorderRadius(90);
            }
        });
    }
}
