package github.nikhilbhutani.intents;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;

/**
 * Created by Nikhil Bhutani on 5/12/2016.
 */
public class ImplictIntents {
    /*
        void call(Context context, String number) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + number));
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) !=
                    PackageManager.PERMISSION_GRANTED) {

                return;
            }
            context.startActivity(callIntent);
        }


        void sendSMS(Context context, String sendToNumber, String message) {

            Uri sendSMSUri = Uri.parse("tel:" + sendToNumber);
            Intent intent = new Intent(Intent.ACTION_VIEW, sendSMSUri);
            intent.putExtra("address", sendToNumber);
            intent.putExtra("sms_body", message);
            intent.setType("vnd.android-dir/mms-sms");
            context.startActivity(intent);
        }
    */
    void openUrlInBrowser(Context context, String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(browserIntent);
    }

    /*

    void showLocationInMap(Context context, String latitude, String longitude, String zoomLevel) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String data = String.format("geo:%s,%s", latitude, longitude);
        if (zoomLevel != null) {
            data = String.format("%s?z=%s", data, zoomLevel);
        }
        intent.setData(Uri.parse(data));
        context.startActivity(intent);
    }
  */

    void takeAPic(Context context, String dir, String fileName) {
        Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString() + "/" + dir, fileName));
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        context.startActivity(intent);
    }

    void openAppPageInPlaystore(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.apircot.greetinsta&hl=en" + context.getPackageName()));
        context.startActivity(intent);
    }
}