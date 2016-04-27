package github.nikhilbhutani.realmdb.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Nikhil Bhutani on 4/27/2016.
 */
public class Country extends RealmObject {

    @PrimaryKey
    private String country_name;
    private int country_population;


    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public int getCountry_population() {
        return country_population;
    }

    public void setCountry_population(int country_population) {
        this.country_population = country_population;
    }
}
