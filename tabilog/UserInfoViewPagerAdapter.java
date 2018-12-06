package kobayashi.reiji.tabilog;

/**
 * Created by kobayashireiji on 2018/10/11.
 */

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by naoi on 2017/04/24.
 */

public class UserInfoViewPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_NUM = 3;

    CharSequence titles[] ={"PAGE1","PAGE2","PAGE3"};

    public UserInfoViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new Page1();
                break;
            case 1:
                fragment = new Page2();
                break;
            default:
                fragment = new Page3();
                break;
        }
        return fragment;
    }



    @Override
    public int getCount() {
        return PAGE_NUM;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
