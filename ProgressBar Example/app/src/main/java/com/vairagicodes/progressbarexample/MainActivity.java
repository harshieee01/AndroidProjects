package com.vairagicodes.progressbarexample;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static int FAKE_DATE_TIME= 3000;
    private int downloadStatus = 0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler();
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.default_progress_bar);
        ProgressBar horizontalProgressBar = findViewById(R.id.horizontal_progress_bar);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        },FAKE_DATE_TIME);


        new Thread(new Runnable() {
            @Override
            public void run() {

                while (downloadStatus<=100) {
                    downloadStatus+=5;
                    horizontalProgressBar.setProgress(downloadStatus);

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }



            }
        }).start();

    }
}