package github.nikhilbhutani.boundservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Boundservice mBoundservice;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                       if(mBound){
                    // Call a method from the LocalService.
                    // However, if this call were something that might hang, then this request should
                    // occur in a separate thread to avoid slowing down the activity performance.
                    int num = mBoundservice.getRandomNumber();
                    Toast.makeText(MainActivity.this, "number: " + num, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Bind to Boundservice class
        Intent intent = new Intent(this,Boundservice.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }



    //This is callback for service binding, passed to bindservice() method in onStart
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //Here we have to bound Boundservice, cast the IBinder and get the Boundservice instance
            Boundservice.LocalBinder binder = (Boundservice.LocalBinder) iBinder;
            mBoundservice = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
          mBound = false;
        }
    };

}
