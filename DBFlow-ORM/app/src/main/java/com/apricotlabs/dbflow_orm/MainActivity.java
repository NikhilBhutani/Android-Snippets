package com.apricotlabs.dbflow_orm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create organization
        Organization organization = new Organization();
        organization.setId(1);
        organization.setName("ApricotLabs");
        organization.save();

        // Create user
        User user = new User();
        user.setName("Nikhil Bhutani");
        user.setOrganization(organization);
        user.save();

        Organization org = new Select().from(Organization.class)
                .where(Organization_Table.id.eq(1))
                .querySingle();

        System.out.println(org.getName());
        System.out.println(user.getName());

    }
}
