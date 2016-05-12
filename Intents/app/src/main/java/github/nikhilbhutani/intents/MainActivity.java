package github.nikhilbhutani.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textview);
        listView = (ListView)findViewById(R.id.listView);

        arrayList = new ArrayList<>();
        arrayList.add("ExplicitIntent with Parcelable Object");
        arrayList.add("Normal Explicit Intent");

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i)
                {
                    case 0:
                        invokeParcelable();
                        break;

                    case 1:
                        invokeNormalIntent();
                        break;
                }
            }
        });



    }

//Explicit Intent with Parcelable Object
    private void invokeParcelable()
    {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        ParcelableModel parcelableModel = new ParcelableModel("Nikhil","I live here");

        intent.putExtra("parcel",parcelableModel);
        intent.putExtra("Intent_type","mymodel");
        startActivity(intent);
    }

//Ecplicit Intent for Result callback
    private void invokeNormalIntent()
    {
        Bundle bundle = new Bundle();
        bundle.putString("simple", "Hello from MainActivity");

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("mybundle",bundle);
        intent.putExtra("Intent_type","get_result");
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            if(requestCode == 1 && data!=null )
            {
                System.out.println("Yeaahhhhh ...............!!!" );
                Bundle bundle = data.getBundleExtra("return_data");

                String text = bundle.getString("thisdata");

                Toast.makeText(MainActivity.this, "Back : " + text, Toast.LENGTH_LONG).show();
            }
        }
    }
}
