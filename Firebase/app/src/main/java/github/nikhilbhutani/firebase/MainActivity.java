package github.nikhilbhutani.firebase;

import android.content.Intent;
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
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    SignInButton signInButton;
    TextView statusTextView;

    GoogleApiClient googleApiClient;
    //you get this URL when you create your firebase database,
    //This is actually the connection String.
    static final String firebaseURL = "https:<YOUR_FIREBASE_URL>.firebaseio.com/";
    private static final int RC_SIGN_IN = 9001;
    private EditText editTextName;
    private TextView textViewUsers;
    private Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTextView = (TextView)findViewById(R.id.statustextview);
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();



       googleApiClient = new GoogleApiClient
               .Builder(this)
               .enableAutoManage(this /* FragmentActivity */, this /*onConnectionFailedListener*/)
               .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
               .build();

        signInButton = (SignInButton)findViewById(R.id.signIn_button);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

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

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

        System.out.print("Connection Failed");
    }


    private void signIn()
    {
        Intent signIn_intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signIn_intent, RC_SIGN_IN);
        System.out.println("signIn method");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Result returned from launching the intent from GoogleSignInApi.getSignInIntent(..);
        if(requestCode == RC_SIGN_IN)
        {
            System.out.println("startActivity method");
            GoogleSignInResult result =
                    Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            statusTextView.setText("Hello, " + acct.getDisplayName());
        } else {
        }
    }

}
