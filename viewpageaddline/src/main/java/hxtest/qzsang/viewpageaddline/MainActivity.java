package hxtest.qzsang.viewpageaddline;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {


    ViewPager viewPage;
    PagerSlidingTab indicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPage = (ViewPager) findViewById(R.id.viewPage);
        indicator = (PagerSlidingTab) findViewById(R.id.indicator);

        viewPage.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        indicator.setViewPager(viewPage);

    }
}
