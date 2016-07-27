package com.github.nikhilbhutani.usingsugerorm;

import com.orm.SugarRecord;

/**
 * Created by Nikhil Bhutani on 7/27/2016.
 */
public class Book extends SugarRecord {

    String title;
    String edition;

    public Book(){

    }

    public Book(String title, String edition){
        this.title = title;
        this.edition = edition;
    }
}
