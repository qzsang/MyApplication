package hxtest.qzsang.viewpageaddline;

import android.support.v4.app.Fragment;

/**
 * fragment的工厂类
 * @author Administrator
 *
 */
public class FragmentFactory {
	/**
	 * 根据position生产对应的fragment的对象
	 * @return
	 */
	public static Fragment create(int position){
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new Tab1Fragment();
			break;
		case 1:
			fragment = new Tab2Fragment();
			break;
		case 2:
			fragment = new Tab3Fragment();
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		}
		return fragment;
	}
}
