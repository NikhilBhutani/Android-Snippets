package github.nikhilbhutani.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


@BindView(R.id.introtext)
    TextView intro;

@BindView(R.id.button)
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

       intro.setText("Butterknife");
    }

@OnClick(R.id.button)
  public void clicked(View view){

       if(view.getId() == R.id.button)
        Toast.makeText(this, "Used Butterknife baamm! ", Toast.LENGTH_SHORT).show();

    }
}
