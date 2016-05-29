package com.example.administrator.mycanvastest.myView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/3/17.
 */
public class DrawView extends View {


    Path path = null;
    Canvas bitmapCanvas = null;//缓存画板
    Bitmap bitmap = null;//缓存位图
    Paint paint = null;//画笔

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);

        path = new Path();

        bitmapCanvas = new Canvas();
        bitmap = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_4444);
        bitmapCanvas.setBitmap(bitmap);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        //风格一定要设置
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        //反锯齿
        paint.setAntiAlias(true);
        paint.setDither(true);
    }


    float prex = 0;
    float prey = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        log("x-y", x + "-" + y);

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(prex, prey, x, y);
                break;

            case MotionEvent.ACTION_UP:
                //将现在花的图像存入bitmap 中
                bitmapCanvas.drawPath(path, paint);
                path.reset();
                break;


        }
        prex = x;
        prey = y;
        invalidate();
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        log("onMeasure",widthMeasureSpec+","+heightMeasureSpec);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        log("onDraw", "onDraw");

        //将原来存在bitmap的图像画出来
        canvas.drawBitmap(bitmap, 0, 0, new Paint());
        //画出当前的路径
        canvas.drawPath(path,paint);
    }


    public void log(String tag, String content) {
        Log.e(tag + "", content + "");
    }

}
