package github.nikhilbhutani.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nikhil Bhutani on 5/12/2016.
 */
public class SecondActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    ListView listView;
    TextView secondtextview;

    ImplictIntents implictIntents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        secondtextview = (TextView)findViewById(R.id.secondtextView);
        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();

       // arrayList.add("Call A Number");
       // arrayList.add("Send a SMS");
        arrayList.add("Open a web page");
        arrayList.add("Take a picture");
        arrayList.add("Open app in playstore");


        if(getIntent().getStringExtra("Intent_type").equals("mymodel"))
        {
            ParcelableModel myparcel = getIntent().getParcelableExtra("parcel");
            // System.out.println("Heeyyyya ..... " +myparcel.getName());
            String text = "Data from MainActivity, Name is: "+myparcel.getName()+ " and Address is: "+myparcel.getAddress();

            secondtextview.setText(text);
        }
        else if(getIntent().getStringExtra("Intent_type").equals("get_result"))
        {
            Bundle bundle = getIntent().getBundleExtra("mybundle");
            String string = bundle.getString("simple");
            String mystring = string;
            secondtextview.setText(mystring);

            arrayList.add("Go to MainActivity");
        }

       implictIntents = new ImplictIntents();

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i)
                {
                    /*
                    case 0:
              //          implictIntents.call(SecondActivity.this, "999990");
                        break;

                    case 1:
                //        implictIntents.sendSMS(SecondActivity.this, "9999000", "Testing");
                        break;
                    */
                    case 0:
                        implictIntents.openUrlInBrowser(SecondActivity.this, "http://www.google.com");
                        break;

                    case 1:
                        implictIntents.takeAPic(SecondActivity.this, "saved_img", "img_1");
                        break;

                    case 2:
                        implictIntents.openAppPageInPlaystore(SecondActivity.this);
                        break;

                    case 3:
                        returnResult();
                        break;

                }
            }
        });


    }

    private void returnResult() {
        Bundle bundle = new Bundle();
        bundle.putString("thisdata", "Returning result from SecondActivity");

        Intent i = new Intent();
        i.putExtra("return_data", bundle);

        setResult(RESULT_OK, i);
        finish();
    }
}
