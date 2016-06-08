package github.nikhilbhutani.text2speech;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
               if(status == TextToSpeech.SUCCESS)
               {
                    int result = textToSpeech.setLanguage(Locale.US);
                   if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                   {
                       Log.e("TTS", "Language not supported");
                   }
               }
                else
               {

                   Log.e("TTS", "Initialization Failed");
               }
            }
        });


        button = (Button)findViewById(R.id.speakButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getwords();
            }
        });


    }


    private void getwords()
    {
        editText =(EditText)findViewById(R.id.words);
        String words = editText.getText().toString();
            speakText(words);
    }

    private void speakText(String words) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            textToSpeech.speak(words, TextToSpeech.QUEUE_FLUSH, null, null);
        }
        else
        {
            textToSpeech.speak(words, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textToSpeech.stop();
        textToSpeech.shutdown();

    }
}
