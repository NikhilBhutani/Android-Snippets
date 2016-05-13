package github.nikhilbhutani.viewpager;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = new ViewPager(this);

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1)
        {
            viewPager.setId(Utils.generateViewId());
        }
        else {
            //This requires minimum API level 17
            viewPager.setId(View.generateViewId());
        }
        //Getting the reference of my relative layout
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.mycontainer);

        relativeLayout.addView(viewPager);

        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
