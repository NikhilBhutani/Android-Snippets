package github.nikhilbhutani.usingpicassolib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    private String imageurl = "http://api.androidhive.info/images/glide/small/deadpool.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.image);

        Picasso.with(this).
                load(imageurl).
                placeholder(R.drawable.placeholder_converted)
                .into(imageView);

    }
}
