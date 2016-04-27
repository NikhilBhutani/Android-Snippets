package github.nikhilbhutani.realmdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import github.nikhilbhutani.realmdb.Models.Country;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

     Realm  myRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         myRealm = Realm.getDefaultInstance();


        myRealm.beginTransaction();

        // Create an object
        Country country1 = myRealm.createObject(Country.class);

        // Set its fields
        country1.setCountry_name("India");
        country1.setCountry_population(1000000000);


        myRealm.commitTransaction();

        RealmResults<Country> results = myRealm.where(Country.class).findAll();

        for(Country c : results)
        {

            Log.d("Country Name is ", c.getCountry_name());
            Log.d("Population is ", Integer.toString(c.getCountry_population()));
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myRealm.close();
    }
}
