package com.example.administrator.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    @ViewInject(id = R.id.tv_1)
    TextView tv_1;
    @ViewInject(id = R.id.btn_1,click = "click")
    Button btn_1;
    @ViewInject(id = R.id.btn_2,click = "click")
    Button btn_2;
    @ViewInject(id = R.id.btn_3,click = "click")
    Button btn_3;
    @ViewInject(id = R.id.btn_4,click = "click")
    Button btn_4;

    String tag = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FinalActivity.initInjectedView(this);
    }

    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello");
            subscriber.onNext("Hi");
            subscriber.onNext("Aloha");
            subscriber.onCompleted();
        }
    });

    public void click (View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                observable.subscribe(subscriber);
                break;

            case R.id.btn_2:
                // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
                observable.subscribe(onNextAction);
                break;
            case R.id.btn_3:
                // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
                observable.subscribe(onNextAction, onErrorAction);
                break;
            case R.id.btn_4:
                // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
                observable.subscribe(onNextAction, onErrorAction, onCompletedAction);
                break;
        }

    }
    //完整回调
    Observer<String> subscriber = new Observer <String>() {
        @Override
        public void onNext(String s) {
            Log.d(tag, "Item: " + s);
            tv_1.append(s);
        }

        @Override
        public void onCompleted() {
            Log.d(tag, "Completed!");
            tv_1.append("Completed!");
        }

        @Override
        public void onError(Throwable e) {
            Log.d(tag, "Error!");
            tv_1.append("Error!");
        }
    };
    //不完整回调

    Action1<String> onNextAction = new Action1<String>() {
        // onNext()
        @Override
        public void call(String s) {
            Log.d(tag, s);
           // int a = 1/0;
        }
    };
    Action1<Throwable> onErrorAction = new Action1<Throwable>() {
        // onError()
        @Override
        public void call(Throwable throwable) {
            // Error handling
            Log.e(tag, throwable.getMessage());
        }
    };
    Action0 onCompletedAction = new Action0() {
        // onCompleted()
        @Override
        public void call() {
            Log.d(tag, "completed");
        }
    };
}
