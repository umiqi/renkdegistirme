package com.example.hafta5odev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ColorActivity extends AppCompatActivity {
    int oran1 = 0, oran2 = 0, oran3 = 0,sayac = 0, kalanRenk = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        Button button2 = (Button) findViewById(R.id.button2);

        Intent intent = getIntent();
        int randomNumber = intent.getIntExtra("randomNumber", 0);

        TextView textView = findViewById(R.id.textView4);
        textView.setText(String.valueOf(randomNumber));

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout2);

        Handler handler = new Handler();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac = 0;
                kalanRenk = randomNumber;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(sayac < randomNumber){
                            oran1 = new Random().nextInt((255) + 1);
                            oran2 = new Random().nextInt((255) + 1);
                            oran3 = new Random().nextInt((255) + 1);

                            int renk = Color.rgb(oran1,oran2,oran3);
                            layout.setBackgroundColor(renk);
                            sayac++;
                            kalanRenk--;

                            textView.setText(String.valueOf(kalanRenk));
                        }
                        handler.postDelayed(this, 2000);
                    }
                }, 2000);
            }
        });
    }
}