package mapfriend.qzsang.fetchannotationtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mapfriend.qzsang.fetchannotationtest.afinal.FinalActivity;
import mapfriend.qzsang.fetchannotationtest.afinal.annotation.view.ViewInject;

public class MainActivity extends Activity {

    @ViewInject(id = R.id.tv_text,click = "click")
    TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FinalActivity.initInjectedView(this);


    }

    public void click(View v) {
        Toast.makeText(this,"你点了我",Toast.LENGTH_SHORT).show();
    }
}
