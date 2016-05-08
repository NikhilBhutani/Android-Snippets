package github.nikhilbhutani.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


     TabLayout nikstablayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nikstablayout = (TabLayout)findViewById(R.id.tablayout);

        nikstablayout.addTab(nikstablayout.newTab().setText("One"));
        nikstablayout.addTab(nikstablayout.newTab().setText("Two"));
        nikstablayout.addTab(nikstablayout.newTab().setText("Three"));

    }
}
