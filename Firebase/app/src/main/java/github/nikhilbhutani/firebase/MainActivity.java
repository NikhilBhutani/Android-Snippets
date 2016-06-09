package github.nikhilbhutani.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {




    //you get this URL when you create your firebase database,
    //This is actually the connection String.
    static final String firebaseURL = "https://ADD YOUR APP URL.firebaseio.com/";

    private EditText editTextName;
    private TextView textViewUsers;
    private Button buttonSave;

 SignInButton signInButton;
    TextView statusTextView;

    GoogleApiClient googleApiClient; 

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the context for Firebase
        Firebase.setAndroidContext(this);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        editTextName = (EditText) findViewById(R.id.editTextName);


        textViewUsers = (TextView) findViewById(R.id.textViewUsers);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating firebase object
                Firebase firebase = new Firebase(firebaseURL);

                //Getting values to store
                String name = editTextName.getText().toString().trim();


                //Creating User object
                Users user = new Users();

                //Adding values
                user.setName(name);

                //Storing values to firebase
                firebase.child("User").setValue(user);


                //Value event listener for realtime data update
                //We get two inner class here 1. DataSnapshot  2. FirebaseError
                //1. DataSnapshot - Reflects back the immediate changes done in the database
                //2. FirebaseError - on any exception error.

                firebase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            //Getting the data from snapshot
                            Users user = postSnapshot.getValue(Users.class);

                            //Adding it to a string
                            String string = "Name: "+ user.getName()+"\n\n";

                            //Displaying it on textview
                            textViewUsers.setText(string);
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }
                });

            }
        });
    }
}
