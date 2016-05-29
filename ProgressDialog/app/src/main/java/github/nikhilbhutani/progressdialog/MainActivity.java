package github.nikhilbhutani.progressdialog;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    Button buttonProgressBar, buttonProgressRing;
    final int totalProgressTime = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonProgressBar = (Button)findViewById(R.id.button);
        buttonProgressRing = (Button)findViewById(R.id.button2);

        buttonProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startShowingProgressBar();
            }
        });

        buttonProgressRing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startShowingProgressRing();
            }
        });

    }


    public void startShowingProgressBar()
    {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Downloading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setProgress(0);
        progressDialog.setIndeterminate(false);
        progressDialog.show();


         Thread mythread = new Thread(){
             @Override
             public void run() {

                 int jumptime = 0;

                 System.out.println("Thread Started");
                 while(jumptime<totalProgressTime)
                 {
                     try {

                         sleep(200);
                         jumptime +=5;
                         progressDialog.setProgress(jumptime);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }

                 }
             }
         };
        mythread.start();

    }


    public void startShowingProgressRing()
    {
        progressDialog = ProgressDialog.show(this,
                "Downloading..","...",false);
         progressDialog.setCancelable(true);

        Thread mythread = new Thread(){
            @Override
            public void run() {

                int jumptime = 0;

                System.out.println("Thread Started");
                while(jumptime<totalProgressTime)
                {
                    try {

                        sleep(200);
                        jumptime +=5;
                        progressDialog.setProgress(jumptime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        mythread.start();

    }

}
