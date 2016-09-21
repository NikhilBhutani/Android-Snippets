package com.apricotlabs.dbflow_orm;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Nikhil Bhutani on 9/22/2016.
 *
 * The Java Objects that need to be declared as models need to extend from BaseModel.
 * Annotate the database too
 *
 */

@Table(database = MyDatabase.class)
public class Organization extends BaseModel {

    @Column
    @PrimaryKey
    int id;

    @Column
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
