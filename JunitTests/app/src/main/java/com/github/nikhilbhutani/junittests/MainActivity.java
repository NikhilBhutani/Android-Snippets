package com.github.nikhilbhutani.junittests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number;
    Button check;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        number = (EditText)findViewById(R.id.edittext);
        check = (Button)findViewById(R.id.enter);
        final PalindromeCheck palindromeCheck = new PalindromeCheck();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(palindromeCheck.checker(number.getText().toString()))
                {
                    result.setText("Palindrome");
                }
                else {
                    result.setText("Not a Palindrome");
                }

            }
        });


    }
}
