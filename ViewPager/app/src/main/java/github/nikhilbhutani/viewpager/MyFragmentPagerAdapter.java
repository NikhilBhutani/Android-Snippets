package github.nikhilbhutani.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Nikhil Bhutani on 5/13/2016.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return FirstPage.newInstance("Hello First",0);
            case 1:
                return FirstPage.newInstance("Hello Second",1);

            case 2:
                return SecondPage.newInstance("Hello Third",2);

            default:
                return FirstPage.newInstance("Main Default Page",0);

        }


    }

    @Override
    public int getCount() {
        return 3;
    }
}
