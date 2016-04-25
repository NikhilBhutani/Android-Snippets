package com.apricot.niks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.apricot.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Hello Niks"," onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Hello Niks"," onStart called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("Hello Niks"," onRestart called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Hello Niks"," onPause called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Hello Niks"," onResume called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Hello Niks"," onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Hello Niks"," onDestroy called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Hello Niks"," onSaveInstanceState called");
    }
}
