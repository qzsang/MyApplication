package com.qzsang.ontouchtest;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by qzsang on 2016/4/9.
 */
public class TestGroupView extends LinearLayout{
    public TestGroupView(Context context) {
        super(context);
    }

    public TestGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TestGroupView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean result = super.dispatchTouchEvent(ev);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:

                Log.e("dispatchTouchEvent","TestGroupView,ACTION_DOWN,"+result);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("dispatchTouchEvent","TestGroupView,ACTION_MOVE,"+result);
                break;

            case MotionEvent.ACTION_UP:
                Log.e("dispatchTouchEvent","TestGroupView,ACTION_UP,"+result);
                break;
        }
        return result;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = true;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("onInterceptTouchEvent","TestGroupView,ACTION_DOWN,"+result);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("onInterceptTouchEvent","TestGroupView,ACTION_MOVE,"+result);
                break;

            case MotionEvent.ACTION_UP:
                Log.e("onInterceptTouchEvent","TestGroupView,ACTION_UP,"+result);
                break;
        }
        return result;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = false;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                Log.e("onTouchEvent","TestGroupView,ACTION_DOWN,"+result);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("onTouchEvent","TestGroupView,ACTION_MOVE,"+result);
                break;

            case MotionEvent.ACTION_UP:
                Log.e("onTouchEvent","TestGroupView,ACTION_UP,"+result);
                break;
        }
        return result;
    }
}
