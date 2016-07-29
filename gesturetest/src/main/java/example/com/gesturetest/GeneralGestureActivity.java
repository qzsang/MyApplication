package example.com.gesturetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class GeneralGestureActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {


    // 定义手势检测器实例
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_gesture);

        //创建手势检测器
        detector = new GestureDetector(this, this);
    }

    //将该Activity上的触碰事件交给GestureDetector处理
    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return detector.onTouchEvent(me);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        Toast.makeText(this, "onDown"
                , Toast.LENGTH_LONG).show();
        return false;
    }

    //onFling  与 onScroll  的区别：  只有快速滑动时才会触发fling
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2
            , float velocityX, float velocityY) {
        Toast.makeText(this, "onFling"
                , Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(this, "onLongPress"
                , Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2
            , float distanceX, float distanceY) {
        Toast.makeText(this, "onScroll",
                Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Toast.makeText(this, "onShowPress"
                , Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Toast.makeText(this, "onSingleTapUp"
                , Toast.LENGTH_LONG).show();
        return false;
    }
}
