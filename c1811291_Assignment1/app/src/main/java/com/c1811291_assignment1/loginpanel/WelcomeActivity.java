package com.c1811291_assignment1.loginpanel;
import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;


public class WelcomeActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        progressBar=findViewById(R.id.progressBar);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter+=5;
                progressBar.setProgress(counter);

                if(counter>=100) {
                    timer.cancel();
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                }

            }
        }; timer.schedule(timerTask,0,100);
    }
}