package com.example.administrator.rxjavatest;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public static int i = 0;
    public ApplicationTest() {
        super(Application.class);

    }


    //rxjava基础
    public void test1 () {


        //观察者  处理事件  相当于监听器
        Observer<String> observer = new Observer<String>() {
            String TAG = "observer";
            @Override
            public void onCompleted() {

                Log.e(TAG ,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG ,"onError:"+e.toString());
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG ,"onNext:"+s);
                if(s.equals("2")) {//让其产生报错
                    int a = 2/0;
                }
            }
        };


        //观察者  处理事件  相当于监听器
        Subscriber<String> subscriber = new Subscriber<String>() {
            String TAG = "subscriber";

            @Override
            public void onStart() {
                super.onStart();

                Log.e(TAG, "onStart");
            }

            @Override
            public void onCompleted() {

                Log.e(TAG ,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG ,"onError:"+e.toString());
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG ,"onNext:"+s);

            }
        };

        //被观察者
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("1");
                subscriber.onNext("2");
                subscriber.onNext("3");
                subscriber.onCompleted();

            }
        });


        //订阅  相当于事件发起
        observable.subscribe(subscriber);
        subscriber.unsubscribe();
        subscriber.onNext("4");
        subscriber.onNext("5");
        subscriber.onCompleted();



    }


}