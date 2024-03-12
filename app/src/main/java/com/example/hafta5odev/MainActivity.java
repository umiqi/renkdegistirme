package com.example.hafta5odev;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int randomNumber;
    int minValue;
    int maxValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button);

        TextView textViewMinValue = (TextView) findViewById(R.id.textView1);
        TextView textViewMaxValue = (TextView) findViewById(R.id.textView3);
        TextView textViewMain = (TextView) findViewById(R.id.textViewMain);

        android.widget.SeekBar sbMin = (android.widget.SeekBar) findViewById(R.id.seekBar1);
        android.widget.SeekBar sbMax = (android.widget.SeekBar) findViewById(R.id.seekBar2);

        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Renk değiştirmeye yönlendiriliyorsunuz...");
        progressDialog.setMessage("Bekleyiniz...");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber = new Random().nextInt((maxValue - minValue) + 1) + minValue;
                textViewMain.setText(String.valueOf(randomNumber));

                progressDialog.show();
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this, ColorActivity.class);
                intent.putExtra("randomNumber", randomNumber);
                startActivity(intent);
            }
        });

        sbMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sbMin.setMin(0);
                sbMin.setMax(15);

                textViewMinValue.setText(String.valueOf(progress));
                minValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sbMax.setMin(16);
                sbMax.setMax(25);

                textViewMaxValue.setText(String.valueOf(progress));
                maxValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}