package com.apricotlabs.generateandscanqrcodes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.pdf417.encoder.BarcodeMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button generateQR;
    private Button scanQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)this.findViewById(R.id.editText);
        generateQR = (Button)this.findViewById(R.id.generate);
        scanQR = (Button)this.findViewById(R.id.scan);

        generateQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String qrtext = editText.getText().toString();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

                try {
                    BitMatrix  bitMatrix = multiFormatWriter.encode(qrtext, BarcodeFormat.QR_CODE, 80, 80);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

                    Intent intent = new Intent(MainActivity.this, QrGenerate.class);
                    intent.putExtra("QR Image", bitmap);
                    startActivity(intent);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });



        scanQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator  intentIntegrator = new IntentIntegrator(MainActivity.this);
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                intentIntegrator.setPrompt("Scan");
                intentIntegrator.setCameraId(0);
                intentIntegrator.setBeepEnabled(false);
                intentIntegrator.setBarcodeImageEnabled(false);
                intentIntegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(intentResult!= null){
            if(intentResult.getContents()==null){

                Toast.makeText(this,"Scanning Stopped", Toast.LENGTH_LONG).show();

            }else
            {
                Toast.makeText(this, intentResult.getContents(), Toast.LENGTH_SHORT).show();
            }
        }else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
