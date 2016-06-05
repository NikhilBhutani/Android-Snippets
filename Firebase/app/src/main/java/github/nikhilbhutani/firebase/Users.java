package github.nikhilbhutani.firebase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Nikhil Bhutani on 6/5/2016.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Users {

    private String name;

    public Users(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
