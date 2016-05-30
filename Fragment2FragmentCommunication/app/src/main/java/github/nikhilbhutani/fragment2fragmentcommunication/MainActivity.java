package github.nikhilbhutani.fragment2fragmentcommunication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentA.Mylistener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendData(String message) {
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.f2);

        fragmentB.getData(message);
    }
}
