package github.nikhilbhutani.audiocapture;

import android.media.MediaRecorder;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Nikhil Bhutani on 5/25/2016.
 */
public class Record {

    MediaRecorder mediaRecorder = null;


    void startRecording(String filename)
    {
        if(mediaRecorder==null) {
            System.out.println("Yes Here I'm");
            mediaRecorder = new MediaRecorder();

            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(filename);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        }
        try
        {
            mediaRecorder.prepare();
        } catch (IOException e) {
            Log.e("prepare ", "failed");
            e.printStackTrace();
        }

        mediaRecorder.start();
        Log.i("Recording ","Started");

    }


    void stopRecording()
    {
        if(mediaRecorder!=null)
        {
            mediaRecorder.stop();
            mediaRecorder.release();
        }
    }


}
