package github.nikhilbhutani.searchview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SearchView;


public class MainActivity extends AppCompatActivity {

    SearchView mysearch;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mysearch = (SearchView)findViewById(R.id.searchView1);
        mysearch.setQueryHint("Search Here");


        mysearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                System.out.println("!!!...Hey Query submitted ");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                System.out.println("!!!...Hey Query changed");
                return false;
            }
        });
    }
}
