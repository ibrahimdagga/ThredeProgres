package com.example.threading;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView tv_time, tv_sacend;
    Button btn_plus , btn_nags , btn_count;
    ProgressBar progressBar;
    int x  = 0;
//    private Handler pHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_time = findViewById(R.id.tv_time);
        tv_sacend = findViewById(R.id.tv_sacend);
        btn_count = findViewById(R.id.btn_count);
        btn_nags = findViewById(R.id.btn_nags);
        btn_plus = findViewById(R.id.btn_plus);



        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                tv_time.setText(Integer.toString(x));

            }
        });

        btn_nags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x--;
                tv_time.setText(Integer.toString(x));


            }
        });

        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Thread t1 = new Thread(new Runnable() {
                   @Override
                   public void run() {
                       for (int i=x;i>=0;i--){

                           try {
                               Thread.sleep(1000);
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                           final int finalI = i ;
                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   tv_sacend.setText(finalI+"");
                               }


                           });

                           progressBar = findViewById(R.id.progressBar);
                           progressBar.setMax(x);
                           progressBar.incrementProgressBy(-1);

                       }


                   }
               });
               t1.start();







            }


        });


    }
}