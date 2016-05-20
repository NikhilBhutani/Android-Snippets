package github.nikhilbhutani.okhttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.btnStart);
        textView = (TextView)findViewById(R.id.txtBytes);
        imageView = (ImageView)findViewById(R.id.imgImage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                download();

            }
        });
    }

    private  void download()
    {
        OkHttpConnection okHttpConnection = new OkHttpConnection();

        byte[] image = new byte[0];

        try {
            image = okHttpConnection.execute().get();

            if(image!=null && image.length>0)
            {
                Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
                imageView.setImageBitmap(bitmap);
                textView.setText("Total bytes "+image.length);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
