package github.nikhilbhutani.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Nikhil Bhutani on 5/10/2016.
 */
public class MyService extends Service{


    //invoked when another component or activity request the service by calling startservice() method
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("invoked", " onStartCommand");

        Toast.makeText(this,"Service Started", Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent, flags, startId);
    }


    //system calls this method when another component wants to bind with the service by calling bindservice()
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("invoked", " onBind");
        return null;
    }

    //Invoked when the service is first created using startCommand or onBind. It is called to perform for one time set Up.
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("invoked", " onCreate");
    }


    //invoked when all the clients have disconnected
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("invoked"," onUnbind ");

        return super.onUnbind(intent);
    }
    //when service is no longer being used and destroyed.
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("invoked"," onDestroy");
    }
}
