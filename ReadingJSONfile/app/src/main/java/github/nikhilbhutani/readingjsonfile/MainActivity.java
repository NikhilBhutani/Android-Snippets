package github.nikhilbhutani.readingjsonfile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
* Created by Nikhil Bhutani
*/

public class MainActivity extends AppCompatActivity {

    TextView textView;
//    String complete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.text);
        List<String> languages = new ArrayList();

        //Reading the json file from the assets folder

        StringBuffer stringBuffer = new StringBuffer();

        BufferedReader bufferedReader = null;

        try {
            System.out.println("Reading JSON");
            bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("lang.json")));

            String mystring;

            while( (mystring = bufferedReader.readLine())!=null)
            {
                     stringBuffer.append(mystring);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

         String jsonString = stringBuffer.toString();
             System.out.println("Read json and your string is "+jsonString);
        //Now parsing the JSON

        try {
            //Creating the json object from complete json string
            JSONObject jsonObject = new JSONObject(jsonString);

            //Creating the JSONarray from the JSONObject
            JSONArray jsonArray = jsonObject.getJSONArray("languages");

            //JSONarray has x JSONobjects
            for(int i=0; i<jsonArray.length(); i++)
            {
             //   System.out.println("Entered "+i);
                //Creating the JSONobject from our JSONarray
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                //Getting data from individual JSONobjects
               String complete = jsonObject1.getString("lang");

                //textView.setText(complete);
                languages.add(complete);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Complete json file in one line :p
        textView.setText(languages.get(0)+" "+languages.get(1)+" "+languages.get(2)+" "+languages.get(3)+" "+languages.get(4));


    }
}
