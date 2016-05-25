package github.nikhilbhutani.audiocapture;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String filename;
    Record record = new Record();
    Play play = new Play();

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textview);

        filename = Environment.getExternalStorageDirectory().getAbsolutePath();

        filename="/audiorecord.3gp";

        FloatingActionButton fabrec = (FloatingActionButton)findViewById(R.id.fab_rec);
        FloatingActionButton fabplay = (FloatingActionButton)findViewById(R.id.fab_play);


        fabrec.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        textView.setText("Recording...");
                        record.startRecording(filename);
                        break;
                    case MotionEvent.ACTION_UP:
                        textView.setText("Recorded");
                        record.stopRecording();
                        break;
                }
                return true;
            }
        });


        fabplay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                play.startPlaying(filename);
                textView.setText("Playing recording..");
                return true;
            }
        });
    }
}
