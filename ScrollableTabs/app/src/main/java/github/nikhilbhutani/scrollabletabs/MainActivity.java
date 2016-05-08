package github.nikhilbhutani.scrollabletabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {


    TabLayout nikstablayout;
    private ViewPager pager;

    private  NiksPagerAdapter madap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        madap = new NiksPagerAdapter(getSupportFragmentManager());
        nikstablayout = (TabLayout)findViewById(R.id.tablayout);

           pager = (ViewPager)findViewById(R.id.pager);
           pager.setAdapter(madap);

        nikstablayout.setupWithViewPager(pager);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public static class MyFragment extends Fragment{

     public static final java.lang.String ARG_PAGE ="arg_page" ;

     public MyFragment()
     {

     }

//NewInstace simply returns a new object of MyFragment after accepting a page number.

     public static MyFragment newInstance(int pageNum)
     {
         MyFragment myFragment = new MyFragment();
         Bundle arguments = new Bundle();
         arguments.putInt(ARG_PAGE,pageNum);
         myFragment.setArguments(arguments);
         return myFragment;
     }


     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
     {
         Bundle argument = getArguments();
         int pageNumber = argument.getInt(ARG_PAGE);
         TextView tv = new TextView(getActivity());
         tv.setText("Inside the Fragment  "+pageNumber);

         tv.setGravity(Gravity.CENTER);
         return tv;
     }
  }



}

class NiksPagerAdapter extends FragmentStatePagerAdapter
{
    public NiksPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        MainActivity.MyFragment myFragment =  MainActivity.MyFragment.newInstance(position);
        return myFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab "+ position;
    }
}

