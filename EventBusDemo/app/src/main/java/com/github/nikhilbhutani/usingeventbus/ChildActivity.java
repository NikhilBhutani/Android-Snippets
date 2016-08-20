package com.github.nikhilbhutani.usingeventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Nikhil Bhutani on 8/20/2016.
 */
public class ChildActivity extends AppCompatActivity{

    EditText editText;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        button = (Button)findViewById(R.id.triggerEvent);
        editText = (EditText)findViewById(R.id.edit_text);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();

                CustomMessageEvent event = new CustomMessageEvent();
                event.setMyString(text);
                EventBus.getDefault().post(event);
                finish();
            }
        });
    }
}
