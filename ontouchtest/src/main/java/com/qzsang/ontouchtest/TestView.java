package com.qzsang.ontouchtest;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by qzsang on 2016/4/9.
 */
public class TestView extends View{
    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TestView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean result = super.dispatchTouchEvent(ev);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("dispatchTouchEvent","TestView,ACTION_DOWN,"+result);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("dispatchTouchEvent","TestView,ACTION_MOVE,"+result);
                break;

            case MotionEvent.ACTION_UP:
                Log.e("dispatchTouchEvent","TestView,ACTION_UP,"+result);
                break;
        }
        return result;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = true;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("onTouchEvent", "TestView,ACTION_DOWN," + result);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("onTouchEvent","TestView,ACTION_MOVE,"+result);
                break;

            case MotionEvent.ACTION_UP:
                Log.e("onTouchEvent","TestView,ACTION_UP,"+result);
                break;
        }
        return result;
    }
}
