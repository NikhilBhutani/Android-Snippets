package com.github.nikhilbhutani.swipepulltorefresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        textView = (TextView)findViewById(R.id.text);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                if(textView.getText().equals("Hello World!"))
                {
                  textView.setText("Change The World!");
                    swipeRefreshLayout.setRefreshing(false);
                }
             else if(textView.getText().equals("Change The World!")){

                    textView.setText("Hello World!");
                    swipeRefreshLayout.setRefreshing(false);
                }

            }
        });
    }
}
