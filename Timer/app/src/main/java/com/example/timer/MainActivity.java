package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int no = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(55000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("Start", "onTick: time started ");
            }

            @Override
            public void onFinish() {
                Log.d("End", "onFinish: time finished ");

            }
        }.start();
    }
}



        //        // timer using handler and runnable
        //        final Handler handler = new Handler();
        //        Runnable run = new Runnable() {
        //            @Override
        //            public void run() {
        //                // code to execute
        //                no ++;
        //                Toast.makeText(MainActivity.this, "hi"+no, Toast.LENGTH_SHORT).show();
        //                handler.postDelayed(this, 1000);
        //
        //            }
        //        };
        //        handler.post(run);




