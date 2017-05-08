package com.example.chiaweizhengterry.timer;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000,1000) {

            @Override
            public void onTick(long l) {
                // count down is counting down every sec
                Log.i("Secs Left",String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                // counter is finished after 10secs
                Log.i("Done!","Counter timer finished");
            }

        }.start();
    }

//    final Handler handler = new Handler();
//
//    Runnable run = new Runnable() {
//        @Override
//        public void run() {
//            //Insert line of code to run every sec
//
//            Log.i("Runnable has run!", "a second has passed");
//
//            handler.postDelayed(this, 1000);
//
//        }
//
//        handler.post(run);
//    };





}
