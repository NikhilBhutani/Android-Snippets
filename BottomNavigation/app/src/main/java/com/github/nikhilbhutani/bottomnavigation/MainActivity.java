 package com.github.nikhilbhutani.bottomnavigation;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setTitle("Bottom Navigation");

        final String[] colors = {"#96CC7A", "#EA705D", "#66BBCC"};

        final MyFragment myFragment = new MyFragment();

        Bundle bundle = new Bundle();

        bundle.putInt("color", Color.parseColor(colors[0]));
        myFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame, myFragment)
                .commit();

        AHBottomNavigation ahBottomNavigation = (AHBottomNavigation)findViewById(R.id.bottom_navigation);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem(getString(R.string.tab_1), R.drawable.ic_map_24dp, R.color.bottomtab_0);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(getString(R.string.tab_2), R.drawable.ic_local_restaurant_24dp, R.color.bottomtab_1);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(getString(R.string.tab_3), R.drawable.ic_store_mall_24dp, R.color.bottomtab_2);

        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);

        ahBottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        ahBottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        ahBottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        ahBottomNavigation.setColored(true);

        ahBottomNavigation.setCurrentItem(0);

        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                myFragment.updateColor(Color.parseColor(colors[position]));

                return true;
            }
        });
    }
}
