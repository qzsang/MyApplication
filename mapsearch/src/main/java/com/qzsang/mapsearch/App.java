package com.qzsang.mapsearch;

import android.app.Application;
import android.util.Log;

import com.amap.api.services.nearby.NearbySearch;

/**
 * Created by qzsang on 2016/4/10.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("App","App");
        NearbySearch mNearbySearch = NearbySearch.getInstance(getApplicationContext());
    }
}
