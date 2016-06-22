package github.nikhilbhutani.usingdagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

  @Inject
  MyHelloService myHelloService;

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.edittext);

        MyApplication.getComponent().inject(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = myHelloService.greeting(editText.getText().toString());

                Toast.makeText(MainActivity.this," "+ msg , Toast.LENGTH_SHORT).show();
            }
        });


    }
}
