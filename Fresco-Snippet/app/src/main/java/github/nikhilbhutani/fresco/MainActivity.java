package github.nikhilbhutani.fresco;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    SimpleDraweeView draweeView;

    String myuri = "http://www.androidbegin.com/tutorial/flag/india.png";

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);

        setContentView(R.layout.activity_main);



        draweeView = (SimpleDraweeView)findViewById(R.id.my_image_view);

        uri = Uri.parse(myuri);

        draweeView.setImageURI(uri);


    }
}
