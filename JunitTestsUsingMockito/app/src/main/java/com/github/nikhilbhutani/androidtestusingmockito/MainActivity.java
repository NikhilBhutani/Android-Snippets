package com.github.nikhilbhutani.androidtestusingmockito;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static Intent createQuery(Context context){

        Intent i = new Intent(context, MainActivity.class);
        return i;
    }


}
