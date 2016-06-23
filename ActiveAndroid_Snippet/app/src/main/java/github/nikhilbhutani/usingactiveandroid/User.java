package github.nikhilbhutani.usingactiveandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Nikhil Bhutani on 6/23/2016.
 */
@Table(name = "users")
public class User extends Model {

 @Column (name = "Name")
 public String name;
 @Column (name = "Organisation")
 public String organisation;


    public User()
    {
     super();
    }

     public User(String name, String organisation)
     {
         super();

        this.name =name;
        this.organisation = organisation;

     }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
}
