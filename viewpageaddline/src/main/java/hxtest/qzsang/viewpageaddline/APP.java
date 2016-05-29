package hxtest.qzsang.viewpageaddline;

import android.app.Application;
import android.content.Context;

/**
 * Created by qzsang on 2016/3/30.
 */
public class APP extends Application{
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
