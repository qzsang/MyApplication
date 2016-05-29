package com.example.administrator.tourguidetest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.tourguidetest.tourguide.Overlay;
import com.example.administrator.tourguidetest.tourguide.ToolTip;
import com.example.administrator.tourguidetest.tourguide.TourGuide;

public class MainActivity extends AppCompatActivity {

    private TextView tv_text;
    private Button btn_button;

    private Animation mExitAnimation;
    private Animation mEnterAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }


    private void init() {

        tv_text = (TextView) findViewById(R.id.tv_text);
        btn_button = (Button) findViewById(R.id.btn_button);

        initAnimation();


        final TourGuide mTourGuideHandler = TourGuide.init(MainActivity.this).with(TourGuide.Technique.Click)
                //  .setPointer(new Pointer())
//                .setToolTip(new ToolTip().setTitle("Welcome!").setDescription("Click on Get Started to begin..."))
//                .setOverlay(new Overlay())
                .setToolTip(new ToolTip()
                                .setTitle(null)
                                .setDescription(null)
                                .setGravity(Gravity.TOP)
                                .setBackgroundColor(Color.TRANSPARENT)
                                .setImageResource(R.drawable.icon_step05)
                )
                .setOverlay(new Overlay()
                                .setBackgroundColor(0x88000000)
                                .setEnterAnimation(mEnterAnimation)
                                .setStyle( Overlay.Style.Rectangle)
                                .setExitAnimation(mExitAnimation)

                )
                .playOn(btn_button);
        btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTourGuideHandler.cleanUp();


            }
        });

    }



    private void initAnimation() {//引导图层动画效果
        mEnterAnimation = new AlphaAnimation(0f, 1f);
        mEnterAnimation.setDuration(600);
        mEnterAnimation.setFillAfter(true);

        mExitAnimation = new AlphaAnimation(1f, 0f);
        mExitAnimation.setDuration(600);
        mExitAnimation.setFillAfter(true);
    }

}
