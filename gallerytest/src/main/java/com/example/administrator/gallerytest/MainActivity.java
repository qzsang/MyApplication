package com.example.administrator.gallerytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Gallery;

public class MainActivity extends AppCompatActivity {

    Gallery g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g = (Gallery) findViewById(R.id.g);
    }
}
