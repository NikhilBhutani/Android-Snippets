package github.nikhilbhutani.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final int ENABLE_BT = 1;
    BluetoothAdapter bluetoothAdapter;
    TextView textView;
    Button on, off, find, listprinter;
    BluetoothDevice bdevice;
    ListView myListView;
    private ArrayAdapter<String> BTArrayAdapter;
    private Set<BluetoothDevice> pairedDevices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textview);
        listprinter = (Button)findViewById(R.id.listButton);
        myListView = (ListView)findViewById(R.id.listView1);

        BTArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        myListView.setAdapter(BTArrayAdapter);


        find = (Button)findViewById(R.id.find);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(bluetoothAdapter==null)
        {
            textView.setText("Phone doesn't support Bluetooth");
        }
        else
        {
            on = (Button)findViewById(R.id.on_button);
            on.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     onBluetooth(view);
                }
            });
        }
        off = (Button)findViewById(R.id.off_button);

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offBluetooth(view);
            }
        });

        listprinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list(view);
            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findDevices(view);
            }
        });
    }

    public void onBluetooth(View v)
    {

        if(!bluetoothAdapter.isEnabled())
        {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent,ENABLE_BT);

            Toast.makeText(MainActivity.this,"Bluetooth is turned on",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Bluetooth is Already On", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==ENABLE_BT)
        {
            if(bluetoothAdapter.isEnabled()) {
                textView.setText("Enabled");
            }else
            {
                textView.setText("Disabled");
            }
        }

    }

    public void offBluetooth(View view)
    {
        bluetoothAdapter.disable();
        textView.setText("Disconnected");
    }


    public void list(View view){

        // get paired devices

        pairedDevices = bluetoothAdapter.getBondedDevices();
        // put it's one to the adapter
        for(BluetoothDevice device : pairedDevices)

        BTArrayAdapter.add(device.getName()+ "\n" + device.getAddress());
        Toast.makeText(getApplicationContext(),"Show Paired Devices",

                Toast.LENGTH_SHORT).show();
    }




    final BroadcastReceiver brReceiver = new BroadcastReceiver() {



        public void onReceive(Context context, Intent intent) {


            String action = intent.getAction();


            // When discovery finds a device

            if (BluetoothDevice.ACTION_FOUND.equals(action)) {

                // Get the BluetoothDevice object from the Intent

                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                System.out.println("Name is "+device.getName());

                Toast.makeText(context, "Name : "+device.getName(),Toast.LENGTH_LONG).show();
                // add the name and the MAC address of the object to the arrayAdapter

                BTArrayAdapter.add(device.getName() + "\n" + device.getAddress());

                BTArrayAdapter.notifyDataSetChanged();

            }

        }

    };



    public void findDevices(View view)
    {

        if (bluetoothAdapter.isDiscovering()) {

            bluetoothAdapter.cancelDiscovery();

        }
        else {
            BTArrayAdapter.clear();
            System.out.println("Starting the discovery");


            bluetoothAdapter.startDiscovery();
            System.out.println("Started");

            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);


            System.out.print("After IntentFilter");
            registerReceiver(brReceiver, filter); // Don't forget to unregister during onDestroy

            //registerReceiver(brReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));

            Toast.makeText(this, " "+bluetoothAdapter.getBondedDevices(), Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
       unregisterReceiver(brReceiver);
    }
}
