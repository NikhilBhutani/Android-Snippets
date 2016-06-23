package github.nikhilbhutani.usingactiveandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView demo;
    Button save, show;
    protected EditText name, organisation;
    ListView listView;
    MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demo = (TextView)findViewById(R.id.demo);
        save = (Button)findViewById(R.id.buttonToSave);
        show = (Button)findViewById(R.id.buttonToShow);
        name = (EditText)findViewById(R.id.name);
        organisation = (EditText)findViewById(R.id.Organisation);
        application = new MyApplication();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedata();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });



    }


    private void savedata() {

        String Name = name.getText().toString();
        String Org = organisation.getText().toString();

        User user = new User(Name,Org);
        user.save();

    }


    private void show() {


        // Create an object of Select to issue a select query
        Select select = new Select();

        //Converting the list of users in arraylist of object users
        ArrayList<User> users = (ArrayList) select.all().from(User.class).execute();

        //Iterating the data and adding it stringbuilder
        StringBuilder builder = new StringBuilder();
        for (User user : users) {
            builder.append("Name: ")
                    .append(user.name)
                    .append(" Organisation : ")
                    .append(user.organisation)
                    .append("\n");
        }

        Toast.makeText(this, builder.toString(), Toast.LENGTH_LONG).show();

    }
}
