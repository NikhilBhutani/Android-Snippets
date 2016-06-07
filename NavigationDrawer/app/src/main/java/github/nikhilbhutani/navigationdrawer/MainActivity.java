package github.nikhilbhutani.navigationdrawer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  Toolbar toolbar;
  NavigationView navigationView;
  DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_design_support_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,
                R.string.drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                //Checking if the item is in checked state or not
               // if not make it in checked state
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                switch (item.getItemId()) {
                    case R.id.menu_bookmark:
                        Toast.makeText(MainActivity.this, "Bookmarked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_save:
                        Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.menu_search:
                        Toast.makeText(MainActivity.this, "Searched", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.menu_share:
                        Toast.makeText(MainActivity.this, "Shared", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.menu_delete:
                        Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.menu_preferences:
                        Toast.makeText(MainActivity.this, "Preferences saved", Toast.LENGTH_SHORT)
                                .show();
                        break;

                    default:
                        break;
                }
                return true;


            }
        });
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}
