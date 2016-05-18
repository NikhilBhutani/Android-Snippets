package github.nikhilbhutani.usingglide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private String imageurl = "http://api.androidhive.info/images/glide/small/deadpool.jpg";
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.image);

        Glide.with(this)
                .load(imageurl)
                .placeholder(R.drawable.placeholder_converted)
                .into(imageView);

    }

}
