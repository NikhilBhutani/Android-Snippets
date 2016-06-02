package github.nikhilbhutani.barcodescannerusingzxinglib;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


//Zebra crossing(Zxing) is an open source, Multiformat 1D/2D Barcode image processing library implemented
// with the part of the other language.

//Zxing library belongs to com.google.zxing.client.android package


public class MainActivity extends AppCompatActivity {


    static final String SCAN = "com.google.zxing.client.android.SCAN";
    Button barcode_scan_button, qrcode_scan_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barcode_scan_button = (Button)findViewById(R.id.Barcode);
        qrcode_scan_button = (Button)findViewById(R.id.qr_button);

        barcode_scan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                barcodeScan();

            }
        });

        qrcode_scan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qrcodeScan();
            }
        });

    }

    public void barcodeScan()
    {
        try{
            Intent intent = new Intent(SCAN);
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            startActivityForResult(intent, 0);
        }catch(ActivityNotFoundException ex)
        {
            showDialog(MainActivity.this, "No Scanner Found", "Download a scanner activity?", "Yes", "No").show();
        }
    }

    private Dialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence Yes, CharSequence No) {

        AlertDialog.Builder  download = new AlertDialog.Builder(act);
        download.setTitle(title);
        download.setMessage(message);
        download.setPositiveButton(Yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });


        download.setNegativeButton(No, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });



        return download.show();
    }

    public void qrcodeScan()
    {


        try{
            Intent intent = new Intent(SCAN);
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);
        }catch(ActivityNotFoundException ex)
        {
            showDialog(MainActivity.this, "Scanner Not Found", "Download a Scanner app?", "Yes", "No").show();
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0)
        {
            if(resultCode == RESULT_OK)
            {
                String contents = data.getStringExtra("SCAN_RESULT");

                String format = data.getStringExtra("SCAN_RESULT_FORMAT");


                Toast.makeText(this, "Content "+ contents + "Format " +format, Toast.LENGTH_SHORT).show();
            }
        }

    }
}
