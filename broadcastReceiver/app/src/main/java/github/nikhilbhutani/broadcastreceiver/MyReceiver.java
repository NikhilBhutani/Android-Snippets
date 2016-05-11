package github.nikhilbhutani.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Nikhil Bhutani on 5/11/2016.
 */
public class MyReceiver extends BroadcastReceiver {

     public MyReceiver()
     {

     }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent!=null && intent.getAction().equals("github.NikhilBhutani.INTENT_ACTION"));
        {
            Toast.makeText(context, intent.getStringExtra("value"), Toast.LENGTH_LONG).show();
        }
    }
}
