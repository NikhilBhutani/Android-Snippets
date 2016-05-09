package github.nikhilbhutani.fragmentslifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Hello Niks"," onCreate called in Activity");

        NiksFragment niksFragment = new NiksFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.your_placeholder,niksFragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Hello Niks"," onStart called in Activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("Hello Niks"," onRestart called in Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Hello Niks"," onPause called in Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Hello Niks"," onResume called in Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Hello Niks"," onStop called in Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Hello Niks"," onDestroy called in Activity");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Hello Niks"," onSaveInstanceState called in Activity");
    }
}
