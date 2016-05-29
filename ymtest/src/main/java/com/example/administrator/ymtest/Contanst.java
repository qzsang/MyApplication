package com.example.administrator.ymtest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/14.
 */
public class Contanst {

    public static List<Activity> activities = new ArrayList<>();

    public static void logout () {
        for (Activity activity :activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        activities.clear();
    }



}