package github.nikhilbhutani.audiocapture;

import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Nikhil Bhutani on 5/25/2016.
 */
public class Play {
    MediaPlayer mediaPlayer;

    public void startPlaying(String filename)
    {
        mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(filename);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            Log.e("prepare ","Failed");
            e.printStackTrace();
        }
    }

}
