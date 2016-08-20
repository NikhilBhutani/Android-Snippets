package com.github.nikhilbhutani.usingeventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private final String LOGTAG = MainActivity.this.getClass().getSimpleName();
    TextView textView;
    Button onToChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.modify_textview);
        onToChild = (Button)findViewById(R.id.buttonToChild);

        //MainActivity to register for events and have some code executed when those
        //events gets fired
        EventBus.getDefault().register(this);

        onToChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, ChildActivity.class));
            }
        });


    }

    //Letting this Activity to know which events it cares about
    @Subscribe
    public void onEvent(CustomMessageEvent event){
        Log.d(LOGTAG, "Event Fired " +event.getMyString());

        textView.setText(event.getMyString());

    }
}
