package hxtest.qzsang.viewpageaddline;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter{
	private String[] tabs;
	public MainPagerAdapter(FragmentManager fm) {
		super(fm);
		tabs = APP.context.getResources().getStringArray(R.array.tab_name);//获取标题资源
	}

	@Override
	public Fragment getItem(int position) {
		return FragmentFactory.create(position);
	}

	@Override
	public int getCount() {
		return tabs.length;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tabs[position];
	}

	

}
