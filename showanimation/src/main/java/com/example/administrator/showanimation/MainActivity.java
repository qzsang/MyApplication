package com.example.administrator.showanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_1;
    Button btn_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);




        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn_2.getVisibility() == View.VISIBLE) {
                    btn_2.setVisibility(View.GONE);
                } else {
                    btn_2.setVisibility(View.VISIBLE);
                    AnimationSet animationSet = new AnimationSet(true);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.setDuration(2000);
                    animationSet.setStartTime(0);
                    btn_2.startAnimation(animationSet);
                }
            }
        });

    }
}
