package com.example.administrator.mycanvastest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click (View v) {


        switch (v.getId()) {
            case R.id.bnt_1:
                startActivity(new Intent(MainActivity.this,HandDrawActivity.class));


                break;

            case R.id.bnt_2:
                startActivity(new Intent(MainActivity.this,LoadingActivity.class));


                break;

        }

    }
}
