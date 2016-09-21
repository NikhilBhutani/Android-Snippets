package com.apricotlabs.dbflow_orm;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Nikhil Bhutani on 9/21/2016.
 */

@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {

    public static final String NAME = "database";
    public static final int VERSION = 1;

}
