package com.apricotlabs.generateandscanqrcodes;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Nikhil Bhutani on 9/27/2016.
 */

public class QrGenerate extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.qr_generate);

        imageView = (ImageView)findViewById(R.id.image);

        Bitmap bitmap = getIntent().getParcelableExtra("QR Image");
        imageView.setImageBitmap(bitmap);




    }
}
