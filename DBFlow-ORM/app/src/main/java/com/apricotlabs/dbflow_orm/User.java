package com.apricotlabs.dbflow_orm;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Nikhil Bhutani on 9/22/2016.
 *
 * We can define a ForeignKey relation easily. The saveForeignKeyModel denotes whether to update the foreign key if the
 * entry is also updated. In this case, we disable this functionality:
 *
 */

@Table(database = MyDatabase.class)
public class User extends BaseModel {

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

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Organization organization;

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setName(String name) {
        this.name = name;
    }



}
